<template>
  <header>
  <!--<img alt="Vue logo" src="../assets/logo.png">-->
  <div id="nav">
    <router-link to="/">Home</router-link>
    <router-link to="/profile">Profile</router-link>
    <router-link to="/test">Test</router-link>
    <router-link to="/flashcards">Flashcards</router-link>
    <router-link to="/drills">Drills</router-link>
    <router-link to="/login">Login</router-link>
  </div>
</header>
</template>

<script>
export default {
    name: "Header",
}
</script>

<style scoped>
header {
  display: grid;
  place-items: center;
}
#nav {
  display: flex;
  flex-direction: row;
  padding: .75rem;
  gap: 1.25em;
  overflow-x: auto;
  overflow-x: overlay;
  max-width: calc(100vw - 2rem);
}
a {
  font-size: 1.5rem;
  font-weight: 600;
  font-family: var(--ff-mono);
  text-decoration: wavy;
  color: var(--clr-text);
}
</style>