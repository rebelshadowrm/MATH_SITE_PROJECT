<template>
  <div class="profile-container" >
    <h1>{{name !== null ? name : getUsername().value}}'s Profile</h1>
    <div class="main">
    <UserCard :username="username" />
    <MessageComponent v-if="username === undefined"/>
    <AddUser v-if="username === undefined" class="addUser"/>
    </div>
  </div>
</template>

<script>

import MessageComponent from "../components/messages/MessageComponent.vue";
import UserCard from '../components/UserCard.vue'
import AddUser from '../components/AddUser.vue'
import useUsers from "../composables/users";
export default {
  name: 'Profile',
  props: {
    username: String,
  },
  data() {
    return {
      name: 'Not Found',
    }
  },
  async created(){
    document.title = "Profile"
    if(this.username !== undefined ) {
      const check = await this.checkUsername(this.username)
      if (check?.username !== undefined) {
        this.name = check?.username
      }
    } else {
      this.name = null
    }
  },
  components: {
    MessageComponent,
    AddUser,
    UserCard,
  },
  methods: {
    async checkUsername(username) {
      try {
        const {AuthHeader} = useUsers()
        const res = await fetch(`/api/user/${username}`, AuthHeader('GET'))
        if(res.status === 200) {
          return await res.json()
        }
      }catch(err){
        console.log(err)
      }
    }
  }
}
</script>
<script setup>
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
