$(function () {
    alert(323);
});


function saveScore() {
    var score1 = $('input[name="radios1"]:checked').val();
    var score2 = $('input[name="radios2"]:checked').val();
    var score3 = $('input[name="radios3"]:checked').val();
    var score4 = $('input[name="radios4"]:checked').val();
    var score5 = $('input[name="radios5"]:checked').val();
    var score6 = $('input[name="radios6"]:checked').val();
    var score7 = $('input[name="radios7"]:checked').val();
    var score8 = $('input[name="radios8"]:checked').val();
    var score9 = $('input[name="radios9"]:checked').val();
    var score10 = $('input[name="radios10"]:checked').val();
    if(score1 =='undefined' || score1 == undefined || score1 == ''){
        alert("请完成所有题目");
        return;
    }
    if(score2 =='undefined' || score2 == undefined || score2 == ''){
        alert("请完成所有题目");
        return;
    }
    if(score3 =='undefined' || score3 == undefined || score3 == ''){
        alert("请完成所有题目");
        return;
    }
    if(score4 =='undefined' || score4 == undefined || score4 == ''){
        alert("请完成所有题目");
        return;
    }
    if(score5 =='undefined' || score5 == undefined || score5 == ''){
        alert("请完成所有题目");
        return;
    }
    if(score6 =='undefined' || score6 == undefined || score6 == ''){
        alert("请完成所有题目");
        return;
    }
    if(score7 =='undefined' || score7 == undefined || score7 == ''){
        alert("请完成所有题目");
        return;
    }
    if(score8 =='undefined' || score8 == undefined || score8 == ''){
        alert("请完成所有题目");
        return;
    }
    if(score9 =='undefined' || score9 == undefined || score9 == ''){
        alert("请完成所有题目");
        return;
    }
    if(score10 =='undefined' || score10 == undefined || score10 == ''){
        alert("请完成所有题目");
        return;
    }

    var id = $('#name').val();
    alert(id);
}