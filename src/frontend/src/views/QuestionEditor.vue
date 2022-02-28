<template>
  <h1>Add & Edit questions</h1>
  <div class="add">
    <AddQuestionForm @new-question="newQuestion"/>
  </div>
  <div class="questions">
    <div v-for="question in questions" :key="question.id" class="question">
      <EditableQuestion :question="question" />
    </div>
  </div>
</template>
<script>
import EditableQuestion from "../components/EditableQuestion";
import AddQuestionForm from "../components/AddQuestionForm";
import useUsers from "../composables/users";
export default {
  name: "QuestionEditor",
  async created(){
    document.title = "Question Setup"
    await this.getQuestions()
  },
  components: {
    EditableQuestion,
    AddQuestionForm
  },
  data() {
    return {
      questions: []
    }
  },
  methods: {
    newQuestion(newQuestion) {
      this.questions.push(newQuestion)
    },
    async getQuestions() {
      const {loadUser, AuthHeader, getUsername} = useUsers()
      await loadUser()
      const res = await fetch(`/api/questions/user/${getUsername().value}`, AuthHeader('GET'))
      this.questions = await res.json()
    }
  }
}

</script>
<style scoped>
.add,
.questions {
  display: flex;
  flex-direction: column;
  padding: 1rem;
  gap: 2rem;
}
h1 {
  margin-left: 1.5rem;
  font-size: var(--txt-xlrg-fluid);
  font-family: var(--ff-serif);
  letter-spacing: 2px;
  color: hsl(var(--clr-white-200) / .1);
  -webkit-text-stroke: 1px hsl(var(--clr-accent-400) / .75);
}
</style>