<template>
  <el-container>
    <el-header>开放执行界面</el-header>
    <el-main>
      <div class="login-container" label-position="left"
           label-width="0px">
        <el-button :type="world.checkButton" :loading="world.loadingType">执行定时脚本</el-button>
        <el-alert
          :title="world.alertTitle"
          :type="world.alertType"
          show-icon>
        </el-alert>
      </div>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'temp',
  data () {
    return {
      world: {
        checkButton: 'info',
        loadingType: true,
        alertTitle: '当前脚本执行中',
        alertType: 'info'
      }
    }
  }
}
</script>

<style scoped>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    /*text-align: center;*/
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    /*text-align: center;*/
    line-height: 240px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    /*text-align: center;*/
    /*line-height: 60px;*/
  }

  .el-button {
    margin-bottom: 12px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 450px;
    padding: 35px 35px 30px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
</style>
