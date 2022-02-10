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

</style>