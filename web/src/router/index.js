import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/login',
    name: 'login',
    component: () => import( '../views/the-login.vue')
  },
  {
    path: '/',
    name: 'main',
    component: () => import( '../views/the-main.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
