const base = {
    get() {
        return {
            url : "http://localhost:8080/jingqupiaowu/",
            name: "jingqupiaowu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/jingqupiaowu/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "景区票务销售系统"
        } 
    }
}
export default base
