function solution(t, p) {
    var answer = 0;
    let t_length = t.length;
    let p_length = p.length;
    
    var arr=[];
    for(var i=0; i<=t_length-p_length; i++){
        arr.push(t.substr(i, p_length));
    }
    
    for(var j=0; j<arr.length; j++){
        if(Number(arr[j]) <= Number(p)){
            answer++;
        }
    }

    return answer;
}