Vue.filter('formatDate',function(date){
    // 格式化时间
    const dateTime = new Date(date);
    const YY = dateTime.getFullYear();
    const MM =
        dateTime.getMonth() + 1 < 10
            ? '0' + (dateTime.getMonth() + 1)
            : dateTime.getMonth() + 1;
    const D =
        dateTime.getDate() < 10 ? '0' + dateTime.getDate() : dateTime.getDate();
    const hh =
        dateTime.getHours() < 10
            ? '0' + dateTime.getHours()
            : dateTime.getHours();
    const mm =
        dateTime.getMinutes() < 10
            ? '0' + dateTime.getMinutes()
            : dateTime.getMinutes();
    const ss =
        dateTime.getSeconds() < 10
            ? '0' + dateTime.getSeconds()
            : dateTime.getSeconds();
    return `${YY}-${MM}-${D} ${hh}:${mm}`;
})