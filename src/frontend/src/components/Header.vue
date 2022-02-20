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
  <div class="header">
    <div class="info">
      <h1>Banana Title Here</h1>
    </div>
  <nav>
    <ul>
      <li><a href="/">Home</a></li>
      <li><a href="/profile">Profile</a></li>
      <li><a href="/test">Test</a></li>
      <li><a href="/flashcards">Flashcards</a></li>
      <li><a href="/drills">Drills</a></li>
      <li><a href="/login">Login</a></li>
      <!-- <router-link to="/">Home</router-link>
      <router-link to="/profile">Profile</router-link>
      <router-link to="/test">Test</router-link>
      <router-link to="/flashcards">Flashcards</router-link>
      <router-link to="/drills">Drills</router-link>
      <router-link to="/login">Login</router-link> -->
    </ul>
  </nav>
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
.header{
  height: 100vh;
  background: linear-gradient(to bottom, rgba(255,255,255,0) 20%,
              rgba(255,255,255,1)), url("../assets/pinkbananas.jpg");
  background-size: cover;
  background-position: top;
  position: relative;
}

.info{
  display: block;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
  backface-visibility: hidden;
  margin-bottom: 30px;
}

nav{
  padding: 10px;
  width: 80%;
  margin: 0 auto;
}

nav ul{
  list-style: none;
  text-align: center;
}

nav ul li{
  display: inline-block;
}

nav ul li a,
nav ul li a:after,
nav ul li a:before{
  transition: all .5s;
}

nav ul li a:hover{
  color: #555;
}

nav ul li a{
  display: block;
  padding: 20px;
  text-decoration: none;
  text-transform: uppercase;
  margin: 0 10px;
}

nav ul li a, nav.fill ul li a{
  position: relative;
}

nav ul li a:after, nav.fill ul li a:after{
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  margin: auto;
  width: 0%;
  content: '.';
  color: transparent;
  background: #333;
  height: 1px;
}

nav ul li a:hover:after{
  width: 100%;
}

nav.fill ul li a{
  transition: all 2s;
}

nav.fill ul li a:after{
  text-align: left;
  content: '.';
  margin: 0;
  opacity: 0;
}

nav.fill ul li a:hover{
  color: #023f1c;
  z-index: 1;
}

nav.fill ul li a:hover:after{
  z-index: -10;
  animation: fill 1s forwards;
  -webkit-animation: fill 1s forwards;
  -moz-animation: fill 1s forwards;
  opacity: 1;
}
</style>