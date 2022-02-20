<template>
  <header>
    <div class="info">
      <h1>Banana Title Here</h1>
    </div>
  <!--<img alt="Vue logo" src="../assets/logo.png">-->
<nav id="nav">
    <router-link to="/">Home</router-link>
    <router-link to="/profile">Profile</router-link>
    <router-link to="/test">Test</router-link>
    <router-link to="/flashcards">Flashcards</router-link>
    <router-link to="/drills">Drills</router-link>
    <router-link to="/login">Login</router-link>
</nav>
</header>
</template>

<script>
export default {
    name: "Header",
}
</script>

<style scoped>
/* header {
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
} */
header {
  height: 100vh;
  background: linear-gradient(to bottom, rgba(255,255,255,0) 20%,
              rgba(255,255,255,1)), url("../assets/pinkbananas.jpg");
  background-size: cover;
  background-position: top;
  position: relative;
}
.info {
  display: block;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
}
nav {
  padding: 1rem;
  max-width: calc(100% - 2rem);
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 1rem;
}
a {
  display: block;
  padding: .75em;
  text-decoration: none;
  text-transform: uppercase;
  position: relative;
  transition: transform ease .5s;
}
a:after {
  content: '';
  position: absolute;
  inset: auto 0 0 0;
  background: #333;
  height: 1px;
  transform: scaleX(0%);
  transition: transform ease .5s;
}
a:hover:after {
  transform: scaleX(100%);
}


</style>