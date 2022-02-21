<template>
  <div class="profile-container" >
    <h1>{{user.userName}}'s Profile</h1>
    <p>Name: {{user.firstName}} {{user.lastName}}<br>
    Email: {{user.email}}
    </p>
  </div>
</template>

<script>
import useUsers from '../composables/users.js'
export default {
  name: 'Profile'
}
</script>
<script setup>
const { state, loadUser } = useUsers()
loadUser()
const user = state.userData


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
