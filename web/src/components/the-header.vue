<template>
  <a-layout-header id="components-layout-demo-top-side-2" class="header">
    <div class="logo" />
    <div style="float: right; color: white;">
      hello：{{member.mobile}} &nbsp;&nbsp;
      <router-link to="/login" style="color: white">
        退出登录
      </router-link>
    </div>
    <a-menu
        v-model:selectedKeys="selectedKeys1"
        theme="dark"
        mode="horizontal"
        :style="{ lineHeight: '64px' }"
    >
      <a-menu-item key="1">nav 11</a-menu-item>
      <a-menu-item key="2">nav 2</a-menu-item>
      <a-menu-item key="3">nav 3</a-menu-item>
    </a-menu>
  </a-layout-header>
</template>

<script>
import {defineComponent, ref} from 'vue';
import store from "@/store";

export default defineComponent({
  name: "the-header-view",
  setup() {
    const selectedKeys1 = ref(['2']);
    let member = store.state.member;

    return {
      selectedKeys1,
      member,
    };
  },
});
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#components-layout-demo-top-side-2 .logo {
  float: left;
  width: 120px;
  height: 31px;
  margin: 16px 24px 16px 0;
  background: rgba(255, 255, 255, 0.3);
}

.ant-row-rtl #components-layout-demo-top-side-2 .logo {
  float: right;
  margin: 16px 0 16px 24px;
}

.site-layout-background {
  background: #fff;
}
</style>
