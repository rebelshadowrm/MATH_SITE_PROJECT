<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <div class="add-message-container">
    <Header @toggleAddMessage="toggleAddMessage" title="Messages" :showAddMessage="showAddMessage" />
    <div v-show="showAddMessage" >
      <AddMessage @addMessage="addMessage" />
    </div>
  </div>
  <Messages @deleteMessage="deleteMessage" :messages="messages" />
  
</template>

<script>
import Header from './components/Header.vue'
import Messages from './components/Messages.vue'
import AddMessage from './components/AddMessage.vue'

export default {
  name: 'App',
  components: {
    Header,
    Messages,
    AddMessage,
  },
  data() {
    return {
      messages: [],
      showAddMessage: false,
    }
  },
  methods: {
    toggleAddMessage() {
      this.showAddMessage = !this.showAddMessage
    },
    async fetchMessages() {
      const res = await fetch('/api/messages')
      const data = await res.json()
      return data
    },
    async fetchMessage(id) {
      const res = await fetch(`/api/messages/${id}`)
      const data = await res.json()
      return data
    },
    async addMessage(message) {
      const res = await fetch('api/messages', { 
        method: 'POST',
        headers: {
          'Content-type': 'application/json',
        },
        body: JSON.stringify(message)
      })
      const data = await res.json()
      this.messages = [...this.messages, data]
    },
    async updateMessage(id) {
      const res = await fetch(`api/messages/${id}`, { 
        method: 'UPDATE',
      })
      const data = await res.json()
      return data
    },
    async deleteMessage(id) {
      if (confirm('Are you sure?')) {
        const res = await fetch(`api/messages/${id}`, {
          method: 'DELETE',
        })
        res.status === 200 ? 
        (this.messages = this.messages.filter((message) => message.id !== id)) :
        alert('Error deleting message')
      }
    }
  },
  async created() {
    this.messages = await this.fetchMessages()
  },
}
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Syne+Mono&display=swap");
*, *::before, *::after {
  box-sizing: border-box;
  padding: 0;
  margin: 0;
}
p {
  max-width: 65ch;
}
IMG {
  display: block;
  max-width: 100%;
  height: auto;
}
:root {
  --bg-main: #202020;
  --clr-text-heading: #f4f4f4;
  --clr-text: #d0d0d4;
  --ff: "Montserrat", sans-serif;
}
body {
  background-color: var(--bg-main);
  color: var(--clr-text);
  font-family: var(--ff);
  line-height: 1.5;
}
#app {
  display: grid;
}
img {
  place-self: center;
}
.btn {
  font-family: var(--ff);
  font-weight: 900;
  text-shadow: 1px 1px 0px hsl(0, 0%, 0%, .3);
  letter-spacing: 1px;
  font-size: 1.1rem;
  padding: .55em 1.2em;
  border-radius: 6px;
  cursor: pointer;
}
.add-message-container {
  border: 1px solid #ccc;
  display: grid;
  margin: 0 1.7rem;
  border-radius: 6px;
}
</style>
