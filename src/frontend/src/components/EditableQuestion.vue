<template>
<div class="container">
  <div class="question">
    <textarea @dblclick="edit" @blur="save"
              v-model="questionTxt"
              :id="question.id" name="question"
              readonly
              ></textarea>
  </div>
  <div class="answers">
    <input @dblclick="edit" @blur="save"
           v-model="answer1"
           :id="question.question.id+'answer1'"
           type="text" name="answer1"
           readonly
            />
    <input @dblclick="edit" @blur="save"
           v-model="answer2"
           :id="question.question.id+'answer2'"
           type="text" name="answer2"
           readonly
            />
    <input @dblclick="edit" @blur="save"
           v-model="answer3"
           :id="question.question.id+'answer3'"
           type="text" name="answer3"
           readonly
            />
    <input @dblclick="edit" @blur="save"
           v-model="answer4"
           :id="question.question.id+'answer4'"
           type="text" name="answer4"
           readonly
            />
  </div>
  <div class="bottom-container">
    <button id="save">save</button>
    <select v-model="subject" id="subject" name="answer" @change="save"  >
      <option value="ADDITION">ADDITION</option>
      <option value="SUBTRACTION">SUBTRACTION</option>
      <option value="MULTIPLICATION">MULTIPLICATION</option>
      <option value="DIVISION">DIVISION</option>
    </select>
    <select v-model="difficulty" id="difficulty" name="answer" @change="save"  >
      <option value=1>1</option>
      <option value=2>2</option>
      <option value=3>3</option>>
    </select>
    <select v-model="correctAnswer" id="answer" name="answer" @change="save"  >
      <option value=1>Answer 1</option>
      <option value=2>Answer 2</option>
      <option value=3>Answer 3</option>
      <option value=4>Answer 4</option>
    </select>
  </div>
</div>
</template>

<script>
import useUsers from "../composables/users";

export default {
  name: "EditableQuestion",
  props: {
    question: {},
  },
  data() {
    return {
      subject: '',
      difficulty: '',
      correctAnswer: '',
      questionTxt: '',
      answer1: '',
      answer2: '',
      answer3: '',
      answer4: '',
      newQuestion: {}
    }
  },
  async created() {
    this.loadQuestion(this.question)
  },
  methods: {
    loadQuestion(question) {
      this.questionTxt = question.question.question
      this.answer1 = question.question.answer1
      this.answer2 = question.question.answer2
      this.answer3 = question.question.answer3
      this.answer4 = question.question.answer4
      this.correctAnswer = question.question.correctAnswer
      this.subject = question.question.subject
      this.difficulty = question.question.difficulty

    },
     edit(e) {
      e.preventDefault()
      e.target.classList.add('editable')
      e.target.readOnly = false;
      const saveBtn = e.target.parentNode.parentNode.querySelector('#save')
      saveBtn.classList.add('show')
    },
    async save(e) {
      e.target.classList.remove('editable')
      const editableElem = document.querySelectorAll('.editable')
      if(editableElem.length === 0) {
        const btn = e.target.parentNode.parentNode.querySelector('#save')
        btn.classList.remove('show')
      }
      this.newQuestion = {
        id: this.question.question.id,
        question: this.questionTxt,
        subject: this.subject,
        difficulty: parseInt(this.difficulty),
        answer1: this.answer1,
        answer2: this.answer2,
        answer3: this.answer3,
        answer4: this.answer4,
        correctAnswer: parseInt(this.correctAnswer)
      }
      const { AuthHeader} = useUsers()
      const options = AuthHeader('PUT', JSON.stringify(this.newQuestion))
      await fetch(`api/questions/teacher/${this.question.id}`, options)
    }
  }
}
</script>

<style scoped>
.container {
  margin: 0 auto;
  padding: 1.25rem 1.5rem;
  max-width: 65ch;
  background: hsl(var(--clr-primary-400) / .1);
  backdrop-filter: blur(7px);
  border-radius: var(--radius);
  border: 1px solid hsl(var(--clr-accent-400) / .7)
}
.answers,
.question {
  display: flex;
  flex-direction: column;
  border-radius: var(--radius);
  gap: 1rem;
}
.question {
  background: hsl(var(--clr-secondary-400) / .75);
  margin-bottom: 1rem;
  padding: 1rem;
}
input[type=text],
textarea {
  color: var(--clr-text);
  background: hsl(var(--clr-secondary-600) / .75);
  padding: .5em;
  border-radius: var(--radius);
  resize: none;
  border: none;
  outline: none;
  font-size: var(--txt-med);
  cursor: pointer;

}
input[type=text] {
  padding: .75em;
}
textarea {
  background: transparent;
}
input[type=text].editable,
textarea.editable {
  color: hsl(var(--clr-black-800));
  background: hsl(var(--clr-white-400));
  cursor: text;

}
.bottom-container {
  display: grid;
  width: 100%;
  padding: 1rem;
  gap: 1rem;
  grid-template-columns: repeat(4, 1fr);
}
#save {
  grid-column: 1/2;
}
#subject {
  grid-column: 2/3;
}
#difficulty {
  grid-column: 3/4;
}
#answer {
  grid-column: 4/5;
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
  #save,
  #subject,
  #difficulty,
  #answer {
    grid-column: initial;
  }
}
#save {
  display: none;
  justify-self: flex-start;
}
#save.show {
  display: inline-block;
  color: var(--clr-text);
  font-size: var(--txt-med);
  font-weight: 500;
  padding: .4em .8em;
  border-radius: var(--radius);
  background: hsl(var(--clr-primary-400) / .1);
  border: 2px solid hsl(var(--clr-accent-400) / .5);
  cursor: pointer;
  transition: background-color 300ms ease-in-out;
}
#save.show:hover {
  background: hsl(var(--clr-white-200) / .1);
}

</style>