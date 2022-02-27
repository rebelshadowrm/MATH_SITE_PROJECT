<template>
  <div class="profile-container" >
    <h1>{{getUsername().value}}'s Profile</h1>
    <div class="main">
    <UserCard/>
    <MessageComponent/>
    <AddUser class="addUser"/>
    </div>
  </div>
</template>

<script>

import MessageComponent from "../components/messages/MessageComponent.vue";
import UserCard from '../components/UserCard.vue'
import AddUser from '../components/AddUser.vue'
export default {
  name: 'Profile',
  created(){
    document.title = "Profile"
  },
  components: {
    MessageComponent,
    AddUser,
    UserCard,
  }
}
</script>
<script setup>
import useUsers from '../composables/users.js'
const { getUsername, loadUser } = useUsers()
loadUser()
</script>
<style scoped>
.profile-container {
  padding: 1.5rem;
}
h1 {
  font-size: var(--txt-xlrg-fluid);
  font-family: var(--ff-serif);
  letter-spacing: 2px;
  color: hsl(var(--clr-white-200) / .1);
  -webkit-text-stroke: 1px hsl(var(--clr-accent-400) / .75);
}
.main {
  display: grid;
  grid-auto-flow: row;
  justify-items: center;
  gap: 2.5rem 1rem;
}
@media only screen and (min-width: 60rem) {
  .main {
    grid-auto-flow: dense;
    grid-template-columns: max-content 1fr;
  }
  .addUser {
    grid-column: 1 / span 3;
    justify-self: flex-start;
  }
}
</style>
