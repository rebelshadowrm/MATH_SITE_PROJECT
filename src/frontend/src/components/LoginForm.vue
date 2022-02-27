<template>
<form @submit.prevent="onSubmit" >
  <h1>Login</h1>
  <span class="error">{{emptyErr === '' ? errorMsg : emptyErr}}</span>
  <div>
    <label for="username">username</label>
    <input v-model="username" id="username" type="text" name="username" />
  </div>
  <div>
    <label for="password">password</label>
    <input v-model="password" id="password" type="password" name="password" />
  </div>

  <input type="submit" value="login"/>
</form>
</template>
<script>
export default {
  name: 'LoginForm',
  props: {
    errorMsg: String,
  },
  data() {
    return {
      username: '',
      password: '',
      emptyErr: '',
    }
  },
  methods: {
    onSubmit(e) {
      this.emptyErr = ''
      if(this.username !== '' && this.password !== '') {
        this.$emit('onSubmit', e)
        this.username = ''
        this.password = ''
      } else {
        this.emptyErr = "Fields cannot be empty!"
      }
    }
  },
}
</script>
<style scoped>
h1 {
  margin-left: .75rem;
}
form {
  background: hsl(var(--clr-primary-200) / .1);
  backdrop-filter: blur(7px);
  border: 2px solid hsl(var(--clr-accent-600) / .3);
  display: grid;
  gap: 1.5rem;
  padding: 2rem;
  min-height: 30rem;
  border-radius: var(--radius);
  max-width: 50ch;
  width: 100%;
  position: relative;
}
input[type="submit"] {
  place-self: start;
  font-size: var(--txt-lrg);
  -webkit-text-stroke: 1px hsl(var(--clr-primary-800));
  background-color: hsl(var(--clr-secondary-400) / .1);
  border: 2px solid hsl(var(--clr-accent-600) / .5);
  color: hsl(var(--clr-white-200));
  padding: .25em .75em;
  border-radius: 3vmin;
  cursor: pointer;
  font-weight: 800;
  text-transform: capitalize;
  transition:
      filter linear 300ms,
      border-color linear 300ms;
}
input[type="submit"]:hover {
  -webkit-text-stroke: 1px hsl(var(--clr-primary-400));
  border-color: hsl(var(--clr-accent-600));
  filter: brightness(130%);
  transition:
      filter ease-in 200ms,
      border-color ease-in 200ms;
}
div {
  display: flex;
  flex-direction: column;
  gap: .5rem;
}
input[type=text],
input[type=password] {
  font-size: var(--txt-med);
  padding: .5rem .75rem;
  border-radius: var(--radius);
  background: hsl(var(--clr-secondary-200) / .1);
  color: var(--clr-text);
  font-weight: 600;
}
label {
  margin-left: .5rem;
  font-size: 2rem;
  font-weight: 700;
  text-transform: capitalize;
}
.error {
  font-size: var(--txt-med);
  font-weight: 600;
  color: hsl(0, 96%, 46%);
  position: absolute;
  inset: 4rem 3rem auto auto;
  pointer-events: none;
}
</style>
