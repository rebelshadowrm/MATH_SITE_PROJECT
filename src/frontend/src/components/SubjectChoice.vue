<template>
<form @Change="formChange" @submit.prevent="onSubmit"  >
  <div class="container">
  <div class="subject-container">
  <input id="addition" type="checkbox" name="addition" />
  <div class="subject-select">
    <p>addition</p>
    <svg class="addition symbol"></svg>
  </div>
  <label for="addition"></label>
  </div>
  <div class="subject-container">
  <input id="subtraction" type="checkbox" name="subtraction" />
  <div class="subject-select">
    <p>subtraction</p>
    <svg class="subtraction symbol"></svg>
  </div>
  <label for="subtraction"></label>
  </div>
  <div class="subject-container">
  <input id="multiplication" type="checkbox" name="multiplication" />
  <div class="subject-select">
    <p>multiplication</p>
    <svg class="multiplication symbol"></svg>
  </div>
  <label for="multiplication"></label>
  </div>
  <div class="subject-container">
    <input id="division" type="checkbox" name="division" />
    <div class="subject-select">
      <p>division</p>
      <svg class="division symbol"></svg>
    </div>
    <label for="division"></label>
  </div>
  </div>
  <div class="question-submit-container">
    <label for="numOfQuestions">Number of questions:</label>
    <div>
      <select id="numOfQuestions" name="numOfQuestions" >
        <option value=5>5</option>
        <option value=10>10</option>
        <option value=15>15</option>
        <option value=20>20</option>
      </select>
      <input v-if="numberOfSubjects > 0" type="submit" value="submit" />
    </div>
  </div>
</form>
</template>
<script>
export default {
  name: "SubjectChoice",
  data() {
    return {
      numberOfSubjects: 0,
    }
  },
  emits: ['onSubmit'],
  methods: {
    formChange(e) {
      if(e.target.checked !== undefined) {
        if (e.target.checked) {
          this.numberOfSubjects++
        } else {
          if(this.numberOfSubjects > 0) {
            this.numberOfSubjects--
          }
        }
      }
    },
    onSubmit(e) {
      this.$emit('onSubmit', e)
    }
  }

}
</script>
<script setup>
</script>
<style scoped>
.container {
  margin-top: 1rem;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  gap: 1rem;
  justify-content: center;
  max-width: 65ch;
}
.question-submit-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1rem;
  gap: 1rem;
  max-width: max-content;
  margin: 0 auto;
}
.question-submit-container div {
  display: grid;
  grid-auto-flow: column;
  gap: 1rem;
  width: 100%;
}
.question-submit-container > * {
  font-size: var(--txt-lrg);
  font-weight: 500;
}
.question-submit-container select,
input[type=submit] {
  padding: .75rem;
  background: hsl(var(--clr-primary-400) / .1);
  border-radius: var(--radius);
  color: inherit;
  border: 1px solid hsl(var(--clr-accent-400) / .7);
}
.question-submit-container option {
  background: initial;
  color: initial;
}
.question-submit-container select {
  justify-self: flex-start;
}
input[type=submit] {
  padding: .5rem 1.5rem;
  justify-self: flex-end;
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
  gap: 1rem;
  height: 15rem;
  border: 2px ridge hsl(var(--clr-accent-400) / .75);
  border-radius: var(--radius);
}
input[type='checkbox'] {
  display: none;
}
.subject-container label {
  position: absolute;
  inset: 0 0 0 0;
  cursor: pointer;
 }
p {
  text-align: center;
  font-weight: 500;
  text-transform: capitalize;
  font-size: var(--txt-lrg);
  pointer-events: none;
  color: hsl(var(--clr-white-200) / .75);
}
input[type='checkbox']:checked + div {
  background-color: hsl(var(--clr-primary-200) / .3);
}
.symbol {
  height: 6rem;
  filter: invert(1) sepia(1) saturate(99999999999999999) hue-rotate(65deg) opacity(.55)
}
</style>
