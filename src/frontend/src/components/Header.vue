<template>
  <header>
    <nav id="nav">
      <router-link  v-if="loggedIn === false" to="/">Home</router-link>
      <router-link  v-if="loggedIn" to="/profile">Profile</router-link>
      <router-link  v-if="loggedIn" to="/test">Tests</router-link>
      <router-link  v-if="loggedIn" to="/flashcards">Flashcards</router-link>
      <router-link  v-if="loggedIn" to="/drills">Drills</router-link>
      <router-link  v-if="loggedIn === false" to="/login">Login</router-link>
      <router-link  v-if="loggedIn" to="/login" @click="logout" >Logout</router-link>
    </nav>
  </header>
</template>

<script>
export default {
    name: "Header",
}
</script>

<script setup>
import useUsers from '../composables/users.js'
import router from '@/router'
  const { getIsLoggedIn, updateIsLoggedIn, loadUser  } = useUsers()
  loadUser()
  const loggedIn = getIsLoggedIn()
  const logout = (e) => {
    e.preventDefault
    updateIsLoggedIn(false)
    router.push('/')
  }
</script>
<style scoped>
header {
  display: grid;
  place-items: center;
  position: relative;
  z-index: 1;
}
nav {
  display: flex;
  flex-direction: row;
  padding: .75rem;
  gap: 1.25em;
  overflow-x: auto;
  overflow-x: overlay;
  max-width: calc(100vw - 2rem);
  height: 7vh;
}
a {
  display: block;
  text-decoration: none;
  text-transform: uppercase;
  position: relative;
  transition: transform ease .5s;
  color: var(--clr-text);
  font-size: var(--txt-lrg);
  font-weight: 200;
  font-family: var(--ff-mono);
}
a::after {
  content: '';
  position: absolute;
  inset: auto 0 0 0;
  background: var(--clr-text);
  height: 2px;
  transform: scaleX(0%);
  transition: transform ease .5s;
}
a:hover::after {
  transform: scaleX(100%);
}


</style>