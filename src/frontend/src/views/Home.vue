<template>
  <div class="info">
    <div class="hero-text">
      <h1>math</h1>
      <h2>It's bananas</h2>
    </div>
    <div class="call-to-action">
    <a href="#getStarted">start here</a>
    </div>
  </div>
  <section>
    <div>
      <h3 id="getStarted" class="about">More about Banana.math</h3>
      <p>Started as a small indy project, we pride ourselves on our wonderful user experience.</p>
      <p>Our UI is completely custom made from the ground up, to bring you the best visual aesthetic combined with lightning fast responsiveness of Vue.js.</p>
    </div>
    <div>
      <h3>Subjects we offer </h3>
      <p>Mathematics</p>
      <ul>
        <li>Addition</li>
        <li>Subtraction</li>
        <li>Multiplication</li>
        <li>Division</li>
      </ul>
    </div>
    <div class="login">
      <router-link to="/login">Login Here</router-link>
    </div>
    <div>
      <h3>To get your own account</h3>
      <h4>Leave a message with an admin</h4>
      <h4 class="warning">Note, messaging service isn't setup properly yet</h4>
      <hr>
      <MessageComponent/>
    </div>
  </section>
</template>
<script>
import MessageComponent from "../components/messages/MessageComponent";
export default {
  name: "Home",
  components: {
    MessageComponent
  },
  created(){
    document.title = "Home"
  }
}
</script>
<style scoped>
.info {
  display: grid;
  gap: 5rem;
  padding: 35vh 2rem 5vh 2rem;
  grid-auto-flow: row;
  grid-auto-rows: max-content;
  width: 100%;
  min-height: 100vh;
  margin-top: -7vh;
  background: linear-gradient(to bottom,
                            rgba(0,0,0, .5),
                            rgba(0,0,0, .1) 50%,
                            rgba(255,255,255, .75)),
                            url("../assets/pinkbananas.jpg");
  background-size: cover;
  background-position: top;
  background-blend-mode:  darken;
}
.hero-text,
.call-to-action {
  place-self: center;
}
h1,
h2 {
  color: hsl(var(--clr-secondary-400) / .5);
  -webkit-text-stroke: 3px hsl(var(--clr-primary-600));
  font-weight: 900;
  font-family: var(--ff-serif);
  line-height: 1;
  text-transform: uppercase;
  letter-spacing: 1px;
}
h1 {
  font-size: var(--txt-xxl-fluid);
  letter-spacing: 1rem;
  transform: translateX(-200%);
  animation: slide 500ms ease-out forwards;
}
h2 {
  font-size: var(--txt-xlrg-fluid);
  margin-left: 1rem;
  color: hsl(var(--clr-accent-200) / .75);
  transform: translateX(-200vw);
  animation: slide 500ms forwards ease-out 500ms;
}
.call-to-action a {
  display: block;
  text-decoration: none;
  padding: .45em .9em;
  font-size: var(--txt-lrg);
  background: hsl(var(--clr-primary-600) / .9);
  color: hsl(var(--clr-secondary-200));
  font-weight: 700;
  font-family: var(--ff-mono);
  letter-spacing: 1px;
  border-radius: var(--radius);
  text-transform: capitalize;
  border: 2px solid hsl(var(--clr-accent-200) / .8);
  cursor: pointer;
  transform: translateX(-200vw);
  animation: slide 500ms forwards ease-out 1000ms;
  transition: filter 350ms ease, box-shadow 200ms ease;
}
.call-to-action a:hover,
.call-to-action a:focus {
  filter: brightness(1.3);
  box-shadow: 2px 2px 4px 0 hsl(var(--clr-white-200) / .5);
  transition: filter 350ms ease, box-shadow 450ms ease;
}
section {
  min-height: 100vh;
  margin: 0 auto;
  padding: 3rem 2rem;
}
.login {
  padding: 2em 1em;
}
.login a {
  color: var(--clr-text);
  text-decoration: none;
  font-weight: 500;
  border: 1px solid hsl(var(--clr-accent-400) / .7);
  background: hsl(var(--clr-primary-400) / .1);
  backdrop-filter: blur(7px);
  padding: 1em 2em;
  border-radius: var(--radius);
  transition: background 300ms ease-out;
}
.login a:hover {
  background: hsl(var(--clr-white-200) / .1);
}
.warning {
  color: red;
  font-size: var(--txt-med);
}
h3 {
  font-size: var(--txt-lrg);
  margin: 1rem 0;
}
section p {
  font-size: var(--txt-med);
}
.about {
  font-size: var(--txt-lrg-fluid);
  padding-top: 1rem;
}
@keyframes slide {
  0% {
    transform: translateX(-200vw);
  }
  100% {
    transform: translateX(0);
  }
}
</style>