<template>
  <p>{{ message.message }}</p>
  <i @click="$emit('deleteMessage', message.id)" class="fas fa-times"></i>
</template>

<script>
export default {
  name: 'Message',
  props: {
    message: Object
  },
  emits: ['deleteMessage'],
}
</script>
<style scoped>
.fas {
  color: red;
  justify-self: end;
  cursor: pointer;
  font-size: 1.6rem;
}
</style>
