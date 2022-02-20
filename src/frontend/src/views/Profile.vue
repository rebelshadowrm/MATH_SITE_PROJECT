<template>
  <div class="profile-container" >
    <h1>{{user.username}}'s Profile</h1>
    <p>Name: {{user.first_name}} {{user.last_name}}<br>
    Email: {{user.email}}
    </p>
    <p>{{error}}</p>
  </div>
</template>

<script>
import useUsers from '../composables/users.js'
//let username = "johhny";
export default {
  name: 'Profile',
/*   data() {
    return {
      user: {id: 1, username: "Johhny", password: "suck1t", email: "johhny@gmail.com", first_name: "Johhny", last_name: "Alpha"},
    }
  },
  methods: {
    async fetchUser() {
        const res = await fetch(`/api/user/${username}`)
        const data = await res.json()
        return data
    },
  } */
  setup: async () => {
    const {user, error, loadUser } = useUsers()
    await loadUser()
    return { user, error }
  }

}
</script>

<style scoped>
.profile-container {
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  gap: 2rem;
  padding: 1rem;
}
h1 {
  margin-left: 1rem;
}
</style>
