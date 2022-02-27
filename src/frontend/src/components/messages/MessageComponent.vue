<template>
  <div class="message-container">
    <Toggle @toggleAddMessage="toggleAddMessage" title="Messages" :showAddMessage="showAddMessage" />
    <AddMessage v-show="showAddMessage" @addMessage="addMessage" />
    <Messages @deleteMessage="deleteMessage" :messages="messages" />
  </div>
</template>

<script>
import Toggle from './Toggle.vue'
import Messages from './Messages.vue'
import AddMessage from './AddMessage.vue'
export default {
  name: 'MessageComponent',
  components: {
    Toggle,
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
      return res.json()
    },
    async fetchMessage(id) {
      const res = await fetch(`/api/messages/${id}`)
      return res.json()
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
      return res.json()
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

<style scoped>
.message-container {
  max-width: 100%;
}
</style>
