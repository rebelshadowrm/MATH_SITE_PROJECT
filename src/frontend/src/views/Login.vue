<template>
  <div class="container">
    <LoginForm @onSubmit="onSubmit" :error-msg="error" />
  </div>
</template>
<script>
import LoginForm from '../components/LoginForm.vue'
import useUsers from '../composables/users.js'
import router from '../router'
export default {
  name: 'Login',
  created(){
    document.title = "Login"
  },
  components: {
    LoginForm,
  },
  data() {
    return {
      error: ''
    }
  },
  methods: {
    async onSubmit(e)  {
      this.error = ''
      const { getUsername, loadUser  } = useUsers()
      const {username, password} = Object.fromEntries(new FormData(e.target))
      const options = {
        method: 'POST',
        body: new URLSearchParams({
          username: `${username}`,
          password: `${password}`
        })
      }
      if(username && password) {
        const res = await fetch('/api/login', options)
        if(res.status === 200) {
          const data = await res.json()
          const {access_token, refresh_token} = data
          if(access_token !== '' && refresh_token !== '') {
            localStorage.setItem("access_token", access_token)
            localStorage.setItem("refresh_token", refresh_token)
            await loadUser()
            if(getUsername()) {
              await router.push('/profile')
            }
          }
        } else {
          this.error = "Invalid login!"
        }
      }
    }
  }
}
</script>
<style scoped>
.container {
  display: grid;
  place-items: center;
  padding: 2rem;
}
</style>
