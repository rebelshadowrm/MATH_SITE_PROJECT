<template>
  <div class="container">
    <LoginForm @onSubmit="onSubmit" />
  </div>
</template>
<script>

import LoginForm from '../components/LoginForm.vue'
export default {
  name: 'Login',
  components: {
    LoginForm,
  },
  data() {
    return {
      username: '',
      password: '',
    }
  },
  methods: {
    async onSubmit(e) {
      const {username, password} = Object.fromEntries(new FormData(e.target))
      this.username = username
      this.password = password
      const options = {
          method: 'POST',
          body: new URLSearchParams({
              username: `${username}`,
              password: `${password}`
        })
    }
      const res = await fetch('/api/login', options)
      const data = await res.json()
      const {access_token, refresh_token} = data
      if(access_token !== '' && refresh_token !== '') {
        localStorage.setItem("access_token", access_token)
        localStorage.setItem("refresh_token", refresh_token)
      }
    }
  },
}
</script>
<style scoped>
.container {
  display: grid;
  place-items: center;
  padding: 2rem;
}
</style>
