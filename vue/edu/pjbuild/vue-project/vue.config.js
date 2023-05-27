const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  runtimeCompiler:true,        //이거 안주면 에러~
  lintOnSave: false
})
