module.exports = {
  lintOnSave: false,
  chainWebpack(config) {
    config.plugin("html").tap(args => {
      args[0].title = "Pet Care";
      return args;
    });
  },
  pwa: {
    iconPaths: {
      favicon32: "favicon.ico",
      favicon16: "favicon.ico",
      appleTouchIcon: "favicon.ico",
      maskIcon: "favicon.ico",
      msTileImage: "favicon.ico"
    }
  }
};
