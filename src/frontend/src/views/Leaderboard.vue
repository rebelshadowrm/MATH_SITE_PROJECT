<template>
  <div class="container">
    <table>
      <tr>
        <th>Username</th>
        <th>Experience</th>
        <th>Level</th>
      </tr>
      <tr v-for="leaderboard in leaderboards" :key="leaderboard.id">
        <td>{{ leaderboard.user }}</td>
        <td>{{ leaderboard.exp }}</td>
        <td>{{ leaderboard.level }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import useUsers from "../composables/users";

export default {
  name: "Leaderboard",
  data() {
    return {
      leaderboards: [],
    }
  },
  created() {
    document.title = "Tests"
    this.loadLeaderboard()
  },
  methods: {
    async loadLeaderboard() {
      const {AuthHeader} = useUsers()
      const res = await fetch('/api/exp', AuthHeader('GET'))
      if(res.status === 200) {
        const json = await res.json()

        json.forEach((el) => {
          console.log(el)
          const roles = el?.user?.roles
          roles.forEach((elem) => {
            if(elem.name === "ROLE_STUDENT") {
              this.leaderboards.push({
                user: el.user.username,
                exp: el.currentExp,
                level: el.level
              }

              )
            }
          })
        })
      }

    }
  }
}
</script>

<style scoped>
.container {
  padding: 2rem;
}
table {
  margin: 0 auto;
  width: 100%;
  max-width: 65ch;
  background: hsl(var(--clr-primary-400) / .1);
  backdrop-filter: blur(7px);
}
table tr,
table td,
table th {
  padding: 1rem;
  border: 1px solid hsl(var(--clr-accent-400) / .75);
  border-collapse: collapse;
}


</style>