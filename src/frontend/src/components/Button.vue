<template>
  <button @click="onClick()"
  class="btn" 
  :style="{ background: bgColor, color: txtColor }">{{text}}</button>
</template>

<script>
export default {
    name: 'Button',
    props: {
        text: String,
        txtColor: String,
        bgColor: String
    },
    methods: {
    onClick() {
        this.$emit('btnClick')
    },
}
}
</script>

<style scoped>
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
</style>