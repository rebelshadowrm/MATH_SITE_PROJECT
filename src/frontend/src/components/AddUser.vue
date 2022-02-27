<template>
  <form v-if="getRoles().value.filter(({name}) => name === 'ROLE_ADMIN').length > 0" class="add-user-form" @submit.prevent="addUser">
    <span class="error">{{errorMsg}}</span>
    <div class="form-input">
      <label for="first_name">first name</label>
      <input id="first_name" name="first_name" type="text" />
    </div>
    <div class="form-input">
      <label for="last_name">last name</label>
      <input id="last_name" name="last_name" type="text" />
    </div>
    <div class="form-input">
      <label for="email">email</label>
      <input id="email" name="email" type="email" />
    </div>
    <div class="form-input">
      <label for="username">username</label>
      <input id="username" name="username" type="text" />
    </div>
    <div class="form-input">
      <label for="password">password</label>
      <input id="password" name="password" type="password" />
    </div>
    <div class="form-input">
      <label for="repeat_password">repeat password</label>
      <input id="repeat_password" name="repeat_password" type="password" />
    </div>
    <div class="role-selection">
      <div class="select">
      <label for="role">Select type</label>
      <select id="role" name="role" @change="selected = $event.target.value" >
        <option value=1>Student</option>
        <option value=2>Parent</option>
        <option value=3>Teacher</option>
        <option value=4>Admin</option>
      </select>
      </div>
      <div v-if="selected !== '1' && selected !== '4'" class="admin">
        <input id="admin" type="checkbox" name="admin" value="true"/>
        <label for="admin">Admin</label>
      </div>
    </div>
    <input type="submit" value="add user"/>
  </form>
</template>
<script>
export default {
  name: 'AddUser',
}
</script>
<script setup>
import useUsers from '../composables/users.js'
import {ref} from 'vue'

let selected = ref('1')
let errorMsg = ref('')


const { AuthHeader, getRoles  } = useUsers()

const addUser = async (e) => {
  const {
      username,
      password,
      repeat_password,
      email,
      first_name,
      last_name,
      role,
      admin
  } = Object.fromEntries(new FormData(e.target))

 const getRole = (role, admin) => {
    if(role !== "ROLE_STUDENT" && admin === 'true') {
      return [{ "id": role }, { "id": 4 }]
    }
    return [{ "id": role }]
 }
 const getIdElem = (elem) => {
    return document.querySelector(`#${elem}`)
 }

  const body = {
    "id": null,
    "username": username,
    "password": password,
    "email": email,
    "first_name": first_name,
    "last_name": last_name,
    "roles": getRole(role, admin)
  }
  if( username !== '' &&
      password !== '' &&
      repeat_password !== '' &&
      email !== '' &&
      first_name !== '' &&
      last_name !== '' &&
      role !== '' &&
      admin !== ''
  ) {
    if(password === repeat_password) {
      const options = AuthHeader('POST', JSON.stringify(body))
      const addUser = await fetch('api/user/save', options)
      if(addUser.status === 201) {
        getIdElem("username").value = ""
        getIdElem("password").value = ""
        getIdElem("repeat_password").value = ""
        getIdElem("email").value = ""
        getIdElem("first_name").value = ""
        getIdElem("last_name").value = ""
      } else if (addUser.status === 422) {
        errorMsg.value = "Username is in use"
      } else {
        errorMsg.value = "Something went wrong, try again!"
      }
    } else {
      errorMsg.value = "Password doesn't match"
      getIdElem("password").value = ""
      getIdElem("repeat_password").value = ""
    }
  } else {
    errorMsg.value = "Fields cannot be empty"
  }
}

</script>
<style scoped>
  .add-user-form {
    display: grid;
    padding: 2rem 2.35rem;
    background: hsl(var(--clr-primary-200) / .1);
    backdrop-filter: blur(7px);
    border: 1px solid hsl(var(--clr-accent-400) / .5);
    border-radius: var(--radius);
    gap: 1.5rem 2rem;
    font-size: var(--txt-med);
    grid-template-columns: 1fr 1fr;
  }
  @media only screen and (max-width: 45rem) {
    .add-user-form {
      grid-template-columns: 1fr;
    }
  }
  .form-input {
    display: grid;
    grid-auto-flow: row;
    line-height: 1;
    gap: .75rem;
  }
  .form-input label {
    margin-left: .8rem;
    font-size: var(--txt-med);
    text-transform: capitalize;
    font-weight: 300;
  }
  .select {
    display: flex;
    flex-direction: column;
  }
  .select label {
    padding: .15rem .45rem;
  }
  .admin {
    display: flex;
    flex-direction: row;
    align-items: center;
    gap: .4rem;
    padding: .5rem;
  }
  .role-selection {
    display: grid;
    grid-auto-flow: column;
    grid-template-columns: max-content 1fr;
    align-items: end;
  }
  .admin label {
    color: hsl(var(--clr-accent-400) / .75);
    font-weight: 700;
    font-size: var(--txt-med);
  }
  input[type="text"],
  input[type="email"],
  input[type="password"] {
    font-size: var(--txt-med);
    padding: .5rem .75rem;
    border-radius: var(--radius);
    background: hsl(var(--clr-secondary-200) / .1);
    color: var(--clr-text);
    font-weight: 600;
    border: 3px outset hsl(var(--clr-accent-400) / .5);
  }
  input[type='checkbox'] {
    --checkbox-size: 1.5rem;
    width: var(--checkbox-size); height: var(--checkbox-size);
    accent-color: hsl(var(--clr-accent-400));
  }
  input[type='submit'] {
    border-radius: var(--radius);
    font-size: var(--txt-med);
    font-family: var(--ff-serif);
    font-weight: 700;
    padding: .75em 0;
    background-color: hsl(var(--clr-secondary-200) / .1);
    color: hsl(var(--clr-accent-200) / .5);
    -webkit-text-stroke: 1px hsl(var(--clr-accent-400) / .75);
    border: 4px outset hsl(var(--clr-accent-400) / .75);
    text-transform: uppercase;
    letter-spacing: 1px;
    align-self: flex-end;
    cursor: pointer;
    transition: filter ease-in 450ms;

  }
  input[type='submit']:hover,
  input[type='submit']:focus-visible {
    filter: brightness(1.35);
    transition: filter ease-in 300ms;
  }
  select {
    font-size: var(--txt-med);
    font-weight: 500;
    background: hsl(var(--clr-secondary-200) / .1);
    border-radius: var(--radius);
    padding: .5rem;
    color: hsl(var(--clr-accent-400));
    border: 2px outset hsl(var(--clr-accent-400) / .5);
    cursor: pointer;
    transition: filter ease-out 300ms;
  }
  select:hover {
    filter: brightness(1.35);
    transition: filter ease 300ms;
  }
  .error {
    font-size: var(--txt-med);
    font-weight: 600;
    color: hsl(0, 96%, 46%);
    position: absolute;
    inset: 0 auto auto auto;
    width: 100%;
    text-align: center;
    pointer-events: none;
  }
</style>
