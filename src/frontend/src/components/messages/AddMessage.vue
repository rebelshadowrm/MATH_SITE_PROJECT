<template>
  <form @submit="onSubmit">
      <div class="form-input">
        <label for="msg"></label>
        <input v-model="msg"
            type="text"
            name="msg"
            id="msg"
            placeholder="Your Message Here" 
        />
        <span class="error">{{err}}</span>
      </div>
      <input type="submit" value="Save Message" class="btn" />
  </form>
</template>
<script>
export default {
    name: 'AddMessage',
    data() {
        return {
            msg: '',
            err: ''
        }
    },
    methods: {
        onSubmit(e) {
            e.preventDefault()
            if(!this.msg) {
                this.err = 'Please add a message'
                return
            }
            const newMessage = {
                message: this.msg
            }
            this.$emit('addMessage', newMessage)
            this.err = ''
            this.msg = ''
        }
    }
}
</script>
<style scoped>
form {
  display: grid;
  grid-auto-flow: row;
  padding: 0 1rem 1.25rem;
  gap: 1rem;
  place-items: center;
}
.form-input {
  display: flex;
  flex-direction: column;
  width: calc(100% - 2rem);
}
input[type="text"] {
  font-weight: 600;
  font-size: 1.2rem;
  padding: .45em .75em;
  border-radius: 6px;
}
input[type="submit"] {
  min-width: 25vw;
  max-width: 100%;
}
.btn {
  font-family: var(--ff-primary);
  font-weight: 900;
  text-shadow: 1px 1px 0px hsl(0, 0%, 0%, .3);
  letter-spacing: 1px;
  font-size: 1.1rem;
  padding: .55em 1.2em;
  border-radius: 6px;
  cursor: pointer;
}
.error {
  display: inline-block;
  color: hsl(0, 100%, 40%);
  font-weight: 600;
  font-size: 1rem;
  padding: .3rem .1rem;
  margin-bottom: -.2rem;
}
</style>