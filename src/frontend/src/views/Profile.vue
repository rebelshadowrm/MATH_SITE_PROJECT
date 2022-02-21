<template>
  <div class="profile-container" >
    <h1>{{user.userName}}'s Profile</h1>
    <div class="main">
    <UserCard/>
    <MessageComponent/>
    <AddUser/>
    </div>
  </div>
</template>

<script>

import MessageComponent from "../components/messages/MessageComponent.vue";
import UserCard from '../components/UserCard.vue'
import AddUser from '../components/AddUser.vue'
export default {
  name: 'Profile',
  components: {
    MessageComponent,
    AddUser,
    UserCard,
  }
}
</script>
<script setup>
import useUsers from '../composables/users.js'
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
.main {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
}
h1 {
  text-align: center;
}
</style>
