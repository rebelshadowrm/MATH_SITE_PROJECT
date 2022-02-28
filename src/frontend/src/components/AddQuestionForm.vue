<template>
<form @submit.prevent="save">
  <div class="question">
    <label for="question">Question</label>
    <textarea v-model="questionTxt"
              id="question" name="question"
    ></textarea>
  </div>
  <div class="answers">
    <label for="answer1">answer 1</label>
    <input v-model="answer1"
           id="answer1"
           type="text" name="answer1"
    />
    <label for="answer2">answer 2</label>
    <input v-model="answer2"
           id="answer2"
           type="text" name="answer2"
    />
    <label for="answer3">answer 3</label>
    <input v-model="answer3"
           id="answer3"
           type="text" name="answer3"
    />
    <label for="answer4">answer 4</label>
    <input v-model="answer4"
           id="answer4"
           type="text" name="answer4"
    />
  </div>
  <div class="bottom-container">
    <select v-model="subject" id="subject" name="answer"  >
      <option value="ADDITION">ADDITION</option>
      <option value="SUBTRACTION">SUBTRACTION</option>
      <option value="MULTIPLICATION">MULTIPLICATION</option>
      <option value="DIVISION">DIVISION</option>
    </select>
    <select v-model="difficulty" id="difficulty" name="answer"  >
      <option value=1>1</option>
      <option value=2>2</option>
      <option value=3>3</option>
    </select>
    <select v-model="correctAnswer" id="answer" name="answer"  >
      <option value=1>Answer 1</option>
      <option value=2>Answer 2</option>
      <option value=3>Answer 3</option>
      <option value=4>Answer 4</option>
    </select>
    <input type="submit" value="add question"/>
  </div>

</form>
</template>

<script>
import useUsers from "../composables/users";

export default {
  name: "AddQuestionForm",
  data() {
    return {
      question: {},
      questionTxt: '',
      answer1: '',
      answer2: '',
      answer3: '',
      answer4: '',
      difficulty: '1',
      subject: 'ADDITION',
      correctAnswer: '1',
    }
  },
  emits: ['newQuestion'],
  methods: {
    async save() {
      this.question = {
        id: null,
        question: this.questionTxt,
        subject: this.subject,
        difficulty: parseInt(this.difficulty),
        answer1: this.answer1,
        answer2: this.answer2,
        answer3: this.answer3,
        answer4: this.answer4,
        correctAnswer: parseInt(this.correctAnswer)
      }
      const { AuthHeader, getUsername} = useUsers()
      const options = AuthHeader('POST', JSON.stringify(this.question))
      const res = await fetch(`api/questions/teacher/${getUsername().value}`, options)
      if(res.status === 201) {
        const newQuestion = {
            id:1,
            question: await res.json()
          }
        await this.$emit('newQuestion', newQuestion)
        this.questionTxt = ''
        this.answer1 = ''
        this.answer2 = ''
        this.answer3 = ''
        this.answer4 = ''
        this.subject = "ADDITION"
        this.difficulty = '1'
        this.correctAnswer = '1'
      }
    }
  }
}
</script>

<style scoped>
form {
  margin: 0 auto;
  padding: 2rem;
  max-widtH: 55ch;
  width: 100%;
  background: hsl(var(--clr-primary-400) / .1);
  backdrop-filter: blur(7px);
  border-radius: var(--radius);
  border: 1px solid hsl(var(--clr-accent-400) / .5);
}
form,
.answers,
.question{
  display: flex;
  flex-direction: column;
  gap: .3rem;
  font-size: var(--txt-med);
}
input[type=submit] {
  margin-top: 1rem;
  font-size: var(--txt-med);
  font-weight: 700;
  padding: 1em 2em;
  color: var(--clr-text);
  background: hsl(var(--clr-primary-400)/ .1);
  border: 1px solid hsl(var(--clr-accent-400) / .75);
  border-radius: var(--radius);
  align-self: flex-start;
  text-transform: capitalize;
  letter-spacing: 1px;
  transition: background-color 300ms ease-in-out;
  cursor: pointer;
}
input[type=submit]:hover {
  background-color: hsl(var(--clr-white-200) / .1);
}
label {
  font-family: var(--ff-mono);
  font-weight: 700;
  padding: .25em 0 0 1em;
  text-transform: capitalize;
}

input[type=text],
textarea {
  border-radius: var(--radius);
  background: hsl(var(--clr-black-800) / .3);
  border: 2px groove hsl(var(--clr-accent-400) / .75);
  resize: none;
  padding: .5em 1em;
  color: var(--clr-text);
}
.bottom-container {
  display: grid;
  padding: 1rem 0;
  gap: 1rem;
  grid-template-columns: repeat(3, 1fr);
}
#subject {
  grid-row: 1/2;
  grid-column: 1/2;
}
#difficulty {
  grid-row: 1/2;
  grid-column: 2/3;
}
#answer {
  grid-row: 1/2;
  grid-column: 3/4;
}
#answer,
#subject,
#difficulty {
  padding: .8em;
  background: hsl(var(--clr-primary-400) / .1);
  border-radius: var(--radius);
  color: var(--clr-text);
  border: 1px solid hsl(var(--clr-accent-400) / .75);
  cursor: pointer;
}
option {
  color: initial;
}
@media only screen and (max-width: 60rem) {
  .bottom-container {
    grid-template-columns: 1fr;
  }
  #subject,
  #difficulty,
  #answer {
    grid-column: initial;
    grid-row: initial;
  }
}
</style>