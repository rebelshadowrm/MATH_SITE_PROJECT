<template>
  <div class="container">
    <LoginForm @onSubmit="onSubmit" />
  </div>
</template>
<script>

import LoginForm from '../components/LoginForm.vue'
import useUsers from '../composables/users.js'
import router from '@/router'
export default {
  name: 'Login',
  components: {
    LoginForm,
  }
}
</script>
<script setup>
  const onSubmit = async (e) => {
    const {username, password} = Object.fromEntries(new FormData(e.target))
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
    if(access_token !== '') {
      localStorage.setItem("access_token", access_token)
    }
    if( refresh_token !== '') {
      localStorage.setItem("refresh_token", refresh_token)
    }
  }
  const {state, loadUser  } = useUsers()
  loadUser()
  if(state.userData?.userName || state.userData.userName !== '') {
    router.push('/')
  }
 

</script>
<style scoped>
.container {
  display: grid;
  place-items: center;
  padding: 2rem;
}
</style>
