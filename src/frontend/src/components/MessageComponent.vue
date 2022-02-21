<template>
    <Toggle @toggleAddMessage="toggleAddMessage" title="Messages" :showAddMessage="showAddMessage" />
    <AddMessage v-show="showAddMessage" @addMessage="addMessage" />
    <Messages @deleteMessage="deleteMessage" :messages="messages" />
</template>

<script>
import Toggle from './Toggle.vue'
import Messages from '/Messages.vue'
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

<style scoped>

</style>
