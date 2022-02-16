<template>
  <div class="card">
    <input class="card-toggle" id="toggle" type="checkbox" />
    <div class="content">
      <div class="card-front">
        <h2 class="card-title">Question</h2>
        <p class="card-description">{{ question }}</p>
        <i class="fa fa-reply-all card-icon"></i>
      </div>
      <div class="card-back">
        <h3 class="card-title">Answer</h3>
        <p class="card-description">{{ answer }}</p>
      </div>
      <label class="toggle-label" for="toggle"></label>
    </div>
  </div>
</template>
<script>
export default {
  name: "Flashcards",
  props: {
    question: String,
    answer: String,
  }
}
</script>
<style>
.card {
  --card-color: hsl(260, 22%, 16%);
  --card-height: 25rem;
  --card-width: 40ch;
  perspective: 200vw;
  min-height: var(--card-height);
  width: 100%;
  max-width: var(--card-width);
  border-radius: var(--radius);

}
.content {
  position: relative;
  min-height: var(--card-height);
  width: 100%;
  max-width: var(--card-width);
  transition: transform 1s;
  transform-style: preserve-3d;
  border-radius: var(--radius);
}
.card-front,
.card-back {
  display: grid;
  min-height: var(--card-height);
  width: 100%;
  max-width: var(--card-width);
  grid-template-rows: max-content 1fr;
  gap: 2em;
  align-items: start;
  justify-items: center;
  position: absolute;
  padding: 3em 2em 5em 2em;
  background-color: var(--card-color);
  border-radius: var(--radius);
  border: 2px inset hsl(0 0% 100% / .33);
  backface-visibility: hidden;
  user-select: none;
  pointer-events: none;
}
.card-back {
  transform: rotateY(180deg);
}
.card-front::after {
  content: "click";
  position: absolute;
  inset: auto 0 0 auto;
  transform: translateX(-80%) translateY(-20%);
  font-size: var(--txt-small);
}
.card-title {
  font-size: var(--txt-med-700);
  font-weight: 700;
}
.card-description {
  font-size: var(--txt-med);
  font-weight: 300;
}
.card-icon {
  position: absolute;
  inset: auto 0 0 auto;
  transform: translateX(-30%) translateY(-30%) rotate(55deg);
}
/***** Toggle ******/
.toggle-label {
  position: absolute;
  display: block;
  inset: 0 0 0 0;
  z-index: 1;
  cursor: pointer;
}
.card-toggle {
  display: none;
}
.card-toggle:checked + .content {
  transform: rotateY(180deg);
  transition: transform 500ms;
}
</style>