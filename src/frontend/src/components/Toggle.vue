<template>
<div class="container">
      <h1>{{ title }}</h1>
      <Button 
        v-show="homePage"
        @btnClick="$emit('toggleAddMessage')" 
        :text="showAddMessage ? 'Close' : 'Add Message'" 
        :bgColor="showAddMessage ? 'red' : 'green'"
        :txtColor="showAddMessage ? '#222' : '#eee'" 
      />
</div>
</template>

<script>
import Button from './Button.vue'
export default {
    name: 'Toggle',
    props: {
        title: String,
        showAddMessage: Boolean,
    },
    components: {
        Button
    },
    computed: {
        homePage() {
            if(this.$route.path === '/') {
                return true
            } else {
                return false
            }
        }
    }
}
</script>

<style scoped>
.container {
    padding: 1rem 3rem;
    display: grid;
    grid-auto-flow: column;
    align-items: center;
    gap: 3rem;
}
button {
    justify-self: end;
}
</style>