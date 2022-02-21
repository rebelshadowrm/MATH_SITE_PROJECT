<template>
  <div class="info">
    <div class="hero-text">
      <h1>math</h1>
      <h2>It's bananas</h2>
    </div>
    <div class="call-to-action">
    <router-link to="/login">start here</router-link>
    </div>
  </div>
</template>
<script>
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
  animation: slide 500ms ease-in forwards;
}
h2 {
  font-size: var(--txt-xlrg-fluid);
  margin-left: 1rem;
  color: hsl(var(--clr-accent-200) / .75);
  transform: translateX(-200%);
  animation: slide 500ms forwards ease-in 350ms;
}
a {
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
  transform: translateX(-200%);
  animation: slide 500ms forwards ease-in 850ms;
  transition: filter 350ms ease, box-shadow 200ms ease;
}
a:hover,
a:focus {
  filter: brightness(1.3);
  box-shadow: 2px 2px 4px 0px hsl(var(--clr-white-200) / .5);
  transition: filter 350ms ease, box-shadow 450ms ease;
}

@keyframes slide {
  0% {
    transform: translateX(-200%);
  }
  100% {
    transform: translateX(0);
  }
}
</style>