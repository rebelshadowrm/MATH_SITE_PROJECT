<template>
<form class="container">
  <div class="subject-container">
  <input id="addition" type="checkbox" name="subject" />
  <div class="subject-select">
    <p>addition</p>
    <svg class="addition symbol"></svg>
  </div>
  <label for="addition"></label>
  </div>
  <div class="subject-container">
  <input id="subtraction" type="checkbox" name="subject" />
  <div class="subject-select">
    <p>subtraction</p>
    <svg class="subtraction symbol"></svg>
  </div>
  <label for="subtraction"></label>
  </div>
  <div class="subject-container">
  <input id="multiplication" type="checkbox" name="subject" />
  <div class="subject-select">
    <p>multiplication</p>
    <svg class="multiplication symbol"></svg>
  </div>
  <label for="multiplication"></label>
  </div>
  <div class="subject-container">
    <input id="division" type="checkbox" name="subject" />
    <div class="subject-select">
      <p>division</p>
      <svg class="division symbol"></svg>
    </div>
    <label for="division"></label>
  </div>
</form>
</template>
<script>
export default {
  name: "SubjectChoice",

}
</script>
<script setup>

</script>
<style scoped>
.container {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  gap: 1rem;
  justify-content: center;
}
.subject-container {
  position: relative;
}
.subject-select {
  background: hsl(var(--clr-primary-200) / .1);
  backdrop-filter: blur(7px);
  -webkit-backdrop-filter: blur(7px);
  aspect-ratio: 1;
  display: grid;
  place-items: center;
  place-content: center;
  gap: 3rem;
  height: 25rem;
  border: 2px ridge hsl(var(--clr-accent-400) / .75);
  border-radius: var(--radius);
}
input[type='checkbox'] {
  display: none;
}
label {
  position: absolute;
  inset: 0 0 0 0;
  cursor: pointer;
 }
p {
  text-align: center;
  font-weight: 700;
  text-transform: capitalize;
  font-size: var(--txt-lrg-fluid);
  pointer-events: none;
  color: hsl(var(--clr-white-200) / .75);
}
input[type='checkbox']:checked + div {
  background-color: hsl(var(--clr-primary-200) / .3);
}
.symbol {
  height: 8rem;
  filter: invert(1) sepia(1) saturate(99999999999999999) hue-rotate(65deg) opacity(.75)
}
</style>
