import {createRouter, createWebHistory} from "vue-router"
import Home from '../views/Home.vue'
import Profile from '../views/Profile.vue'
import Test from '../views/Test.vue'
import Flashcards from '../views/Flashcards.vue'
import Drills from '../views/Drills.vue'

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/profile',
        name: 'Profile',
        component: Profile
    },
    {
    path: '/test',
    name: 'Test',
    component: Test
    },
    {
    path: '/flashcards',
    name: 'Flashcards',
    component: Flashcards
    },
    {
    path: '/drills',
    name: 'Drills',
    component: Drills
    },

]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router