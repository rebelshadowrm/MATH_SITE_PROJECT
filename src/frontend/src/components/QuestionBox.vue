<template>
    <div :key="question.id" v-for="(question) in questions" class="question-box">
      <p class="question">{{question.question}}</p>
      <div class="answer-box" >
        <span class="answer-input" >
          <input  :data-id="question.id"
                  :id="'q'+question.id+'answer1'"
                  :name="question.id"
                  type="radio" value="1"
          />
          <label :for="'q'+question.id+'answer1'">{{ question.answer1 }}</label>
        </span>
        <span class="answer-input" >
          <input :data-id="question.id"
                 :id="'q'+question.id+'answer2'"
                 :name="question.id"
                 type="radio" value="2"
          />
          <label :for="'q'+question.id+'answer2'">{{ question.answer2 }}</label>
        </span>
        <span class="answer-input" >
          <input :data-id="question.id"
                 :id="'q'+question.id+'answer3'"
                 :name="question.id"
                 type="radio" value="3"
          />
          <label :for="'q'+question.id+'answer3'">{{ question.answer3 }}</label>
        </span>
        <span class="answer-input" >
          <input :data-id="question.id"
                 :id="'q'+question.id+'answer4'"
                 :name="question.id"
                 type="radio" value="4"
          />
          <label :for="'q'+question.id+'answer4'">{{ question.answer4 }}</label>
        </span>
      </div>
    </div>
</template>
<script>
export default {
  name: 'QuestionBox',
  props: {
    questions: Array,
  },
}
</script>

<style scoped>
.question-box {
  display: grid;
  max-width: 65ch;
  padding: 1.3rem;
  gap: 1.5rem;
  color: var(--clr-text);
  border: 2px solid hsl(var(--clr-accent-600) / .3);
  background-color: hsl(var(--clr-primary-200) / .1);
  backdrop-filter: blur(7px);
  font-weight: 700;
  border-radius: 20px;
}
.question {
  display: inline-block;
  padding: 2rem;
  background-color: hsl(var(--clr-secondary-600) / .7);
  border-radius: var(--radius);
  font-weight: 500;
  font-size: var(--txt-lrg);
}
.answer-box {
  display: grid;
  grid-auto-flow: row;
  gap: 1rem;
  border-radius: 20px;
}
.answer-input {
  display: grid;
  grid-template-columns: max-content 1fr;
  gap: .5rem;
  border-radius: 20px;
  align-items: baseline;
  background-color: hsl(var(--clr-secondary-600) / .3);
  font-size: var(--txt-small-fluid);
}
input:checked + label {
  box-shadow: -1.35rem 0 0 hsl(var(--clr-secondary-400) / .35);
  background: hsl(var(--clr-secondary-400) / .35);
  transition: box-shadow 150ms ease 75ms, background 250ms ease-out;
}
input {
  /*accent-color: hsl(var(--clr-accent-400));*/
  opacity: 0;
  margin: 0;
}
label {
  background: transparent;
  display: inline-block;
  padding: 1.25rem .25rem;
  font-size: var(--txt-med);
  border-radius: 20px;
}
</style>
