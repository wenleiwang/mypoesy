$(document).ready(function () {
    var init = {
        startYear: 1900, //年份列表开始年
        endYear: 2050 //年份列表结束年
    };
    var fun = {
        init: function(){
            this.showYear();
            this.timeBox();
            this.dateBox();
        },
        showYear: function(){ //循环年列表
            var startYear = init.startYear,
                endYear = init.endYear,
                yearHtml = '';
            for(;startYear <= endYear; startYear++){
                yearHtml += '<li value="'+startYear+'">'+startYear+'年</li>';
            };
            $('.select-year').html(yearHtml);
        },
        timeBox: function(){ //系统时间
            (function(){
                var date = new Date();
                var h = date.getHours(),
                    m = date.getMinutes(),
                    s = date.getSeconds();
                var time = h + ':' + m + ':' + s;
                var time = fun.timeBu(time);
                $('.time').html(time);
                setTimeout(arguments.callee, 1000);
            })();
        },
        timeBu: function(val){
            var arr = val.split(':');
            for(var i = 0; i < arr.length; i++){
                if(arr[i] < 10){
                    arr[i] = '0' + arr[i];
                }
            };
            return arr.join(':');
        },
        showDate: function(year, month){ //日历展示
            //改变下拉
            $('.year-text').text(year + '年').attr('value', year);
            $('.month-text').text(month + '月').attr('value', month);
            $('.select-list li').removeClass('selected');
            //为当前已经默认的年份和有份标为选中
            $('.select-list li').addClass(function(i){
                var value = $(this).attr('value');
                if(value == year || value == month){
                    return 'selected';
                }
            });

            var setDate = new Date();
            setDate.setFullYear(year); //设置年份
            setDate.setMonth(month-1); //设置月份，因为系统的月份都是比真实的小1
            setDate.setDate(1); //设置成当前月第一天

            var num = setDate.getDay(); //得到本月第一天是星期几

            setDate.setMonth(month); //设置成正确的真实月份
            var lastDate = new Date(setDate.getTime() - 1000*60*60*24); //计算得到当前月最后一天的日期格式
            var lastDay = lastDate.getDate(); //获取本月最后一天是几号
            //alert(num);
            //利用得到的当前月总天数来循环出当前月日历
            var html = '';
            var num2 = 1;
            for(var i = 1; i <= lastDay; i++){
                if((num2 % 7) == 1){
                    html += '<tr>'
                }
                if(i == 1){
                    if(num != 0){
                        html+= '<td colspan="'+ num +'"></td></td>';
                        num2 = num + 1;
                    }
                }
                html += '<td class="everyDayTable">\n' +
                    '                    <div class="day03">' + i + '</div>\n' +
                    '                    <ul>\n' +
                    '                        <li class="chi"></li>\n' +
                    '                        <li class="cheng"></li>\n' +
                    '                        <li class="huang"></li>\n' +
                    '                        <li class="lu"></li>\n' +
                    '                        <li class="qing"></li>\n' +
                    '                        <li class="lan"></li>\n' +
                    '                        <li class="zi"></li>\n' +
                    '                    </ul>\n' +
                    '                </td>';
                if((num2 % 7) == 0){
                    if(num2 == 7){
                        html += '<td rowspan="5" class="LineFore"></td>';
                    }
                    html+='</tr>';
                }
                num2++;
            };
            $('.table').html(html);
//根据得到的本月第一天是周几得出第一个li所在的位置，从而排列好整个日历
            var nowDate = new Date(), //得到系统当前的真实时间
                nowYear = nowDate.getFullYear(),
                nowMonth = nowDate.getMonth() + 1,
                today = nowDate.getDate(); //获取当前是几号
            if(nowYear == year && nowMonth == month){ //验证当前展示中是否包含今天
                $('.table li').eq(today-1).find('span').addClass('today'); //标出今天
            }

        },
        dateBox: function(){
            var date = new Date(),
                year = date.getFullYear(), //获取当前是哪一年
                month = date.getMonth() + 1; //获取当前月

            //初始化日历
            fun.showDate(year, month);

        }
    }
    fun.init(); //运行
    //下拉选择
    $('.select-text').on('click', function(e){
        e.stopPropagation();
        var self = $(this);
        self.toggleClass('current');
        self.parent().siblings('.select').find('.select-list').hide();
        self.prev().toggle();
        //点击是的年份时则始终保持已经选中的年在第一位
        if(self.hasClass('year')){
            $('.select-year').scrollTop(0);
            var top = $('.select-year .selected').position().top;
            $('.select-year').scrollTop(top);
        }
    });
    //下拉悬浮
    $('.select-list li').on({
        'mouseenter': function(){
            $(this).addClass('on');
        },
        'mouseleave': function(){
            $(this).removeClass('on');
        }
    });
    $(document).on('click', function(){
        $('.select-list').hide();
        $('.select-text').removeClass('current');
    });
    //切换年，月
    $('.select-list li').on('click', function(){
        if($(this).hasClass('selected')){ //如果是已经选中的则不用在重新初始化日历
            return;
        };
        var self = $(this),
            text = self.text(),
            value = self.attr('value');
        self.addClass('selected').siblings().removeClass('selected');
        self.parent().next().find('span').text(text).attr('value', value);
        var year = $('.year-text').attr('value'),
            month = $('.month-text').attr('value');
        fun.showDate(year, month);
    });

    //返回今天
    $('.select-today').on('click', function(){

        fun.dateBox();
    });

    //日期选择
    //日期悬浮时
    $('body').on({
        'mouseenter': function(){
            $(this).addClass('on');
        },
        'mouseleave': function(){
            $(this).removeClass('on');
        }
    }, '.table span');
    //点击日期
    $('body').on('click', '.table span', function(){
        var year = $('.year-text').attr('value'),
            month = $('.month-text').attr('value'),
            day = $(this).text();
        var date = year + '-' + month + '-' + day;
        alert(date);
    });

    //前一个月
    $('.select-prev').on('click', function(){
        var year = parseInt($('.year-text').attr('value')),
            month = parseInt($('.month-text').attr('value'));
        if(month - 1 > 0){
            month = month - 1;
        }else{
            month = 12;
            year = year - 1;
            if(year < init.startYear){
                return;
            }
        };
        fun.showDate(year, month);
    });
    //后一个月
    $('.select-next').on('click', function(){
        var year = parseInt($('.year-text').attr('value')),
            month = parseInt($('.month-text').attr('value'));
        if(month + 1 <= 12){
            month = month + 1;
        }else{
            month = 1;
            year = year + 1;
            if(year > init.endYear){
                return;
            }
        };
        fun.showDate(year, month);
    })

});