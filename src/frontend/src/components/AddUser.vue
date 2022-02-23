<template>
  <form v-if="getRoles().value.filter(({name}) => name === 'ROLE_ADMIN').length > 0" class="add-user-form" @submit.prevent="addUser">
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

const selected = ref('1')

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


  const body = {
    "id": null,
    "username": username,
    "password": password,
    "email": email,
    "first_name": first_name,
    "last_name": last_name,
    "roles": getRole(role, admin)
  }
  const options = AuthHeader('POST', JSON.stringify(body))

  console.log(role, admin)
  console.log(options)
  const addUser = await fetch('api/user/save', options)
  console.log(addUser)
  console.log(await addUser.json())
}

</script>
<style scoped>
  .add-user-form {
    display: grid;
    padding: 2rem;
    background: hsl(var(--clr-primary-200) / .1);
    backdrop-filter: blur(7px);
    border: 1px solid hsl(var(--clr-accent-400) / .5);
    border-radius: var(--radius);
    gap: 1.2rem;
    font-size: var(--txt-med);
  }
  .form-input {
    display: grid;
    grid-template-columns: 10ch 1fr;
    align-items: center;
    line-height: 1;
  }
  .select {
    display: flex;
    flex-direction: column;
  }
  .select label {
    padding: .25rem .5rem;
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
    padding: 1rem 0;
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
  }
  input[type='checkbox'] {
    --checkbox-size: 1.5rem;
    width: var(--checkbox-size); height: var(--checkbox-size);
    accent-color: hsl(var(--clr-accent-400));
  }
  select {
    font-size: var(--txt-med);
    background: hsl(var(--clr-secondary-200) / .1);
    border-radius: var(--radius);
    padding: .5rem;
    color: hsl(var(--clr-accent-400));
  }

</style>
