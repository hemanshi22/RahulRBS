// Type of Accounts Pie Chart 

    //<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    //<script type="text/javascript">
		
      google.charts.load("current", {packages:["corechart"]});
     
      function drawChart1() {
        var data = google.visualization.arrayToDataTable(transData);

        

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
      MYFUNC1 = function() {
    	  google.charts.setOnLoadCallback(drawChart1);
    	 
      };
  



//<!--  Credit/Debit Pie Chart -->

//script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
   // <script type="text/javascript">
     // google.charts.load("current", {packages:["corechart"]});
    
      function drawChart2() {
        var data = google.visualization.arrayToDataTable([
          ['Credit Transactions', 'Debit Transactions'],
          ['Credit',     11],
          ['Debit',      7]
          
          
        ]);

        var options = {
          title: 'Credit vs Debit Transactions',
          width: 800,
          height: 480,
          title: 'Credit vs Debit',
          colors: ['#878BB6', '#4ACAB4'],

          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart2_3d'));
        chart.draw(data, options);
      }
      MYFUNC2 = function() {
    	  google.charts.setOnLoadCallback(drawChart2);
    	 
      };
    //</script>
   
 

//!-- Area Chart No. of Transactions Yearwise All account types  -->


    //  google.charts.load('current', {'packages':['corechart']});
   

      function drawChart3() {
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Current', 'Savings', 'Term Deosits','Foreign Exchange'],
          ['2013',  1000,      400,		700,		300],
          ['2014',  1170,      460,		1500,		800],
          ['2015',  660,       1120,	800,		300],
          ['2016',  1030,      540,		600,		400]
        ]);

        var options = {
          title: 'No. of Transactions by Account Type',
          hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0}
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
      MYFUNC3 = function() {
    	  google.charts.setOnLoadCallback(drawChart3);
    	 
      };

   

    
    //<!-- Area Chart Balance Timeline All account types  -->
    

     // google.charts.load('current', {'packages':['corechart']});
      
      	SINJINI='';
      function drawChart4() {
        var data = google.visualization.arrayToDataTable(SINJINI);
        var options = {
  	          title: 'Balance vs Timeline',
  	          curveType: 'function',
  	          legend: { position: 'bottom' }
  	        };

  	        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

  	        chart.draw(data, options);

        
      }
      MYFUNC4 = function() {
    	  SINJINI=[
    	           ['Timeline', 'Current', 'Savings', 'Term Deposits', 'Foreign Exchange'],
    	           ['2004',  1000,      400,		700,		1200],
    	           ['2005',  1170,      460,		800,		1500],
    	           ['2006',  660,       1120,	900,		1300],
    	           ['2007',  1030,      540,		500,		800]
    	         ];
    	  google.charts.setOnLoadCallback(drawChart4);
    	 
      };
    
    
     //<!-- Bar Chart Balance Timeline All account types  -->
     
     

   
      json_var = { role: "style" };
      den =  "Density";
      arr0 =  ["Element"];
      mar = 'stroke-color: #f6c7b6; stroke-opacity: 0.6; stroke-width: 8; fill-color: #FF8153; fill-opacity: 0.2';
      apr = "Apr";
      ARR1 = ["Jan", 8.94, 'stroke-color: #f6c7b6; stroke-opacity: 0.6; stroke-width: 8; fill-color: #FF8153; fill-opacity: 0.2'];
      ARR2 =  ["Feb", 10.49, 'stroke-color: #871B47; stroke-opacity: 0.6; stroke-width: 8; fill-color: #FFEA88; fill-opacity: 0.2'];
      arr3 = ["Mar", 8.94];
      arr4 = [10.49, 'stroke-color: #871B47; stroke-opacity: 0.6; stroke-width: 8; fill-color: #FFEA88; fill-opacity: 0.2'];
      sarr = [arr0, ARR1, ARR2];




    //google.charts.load("current", {packages:["corechart"]});
 
    function drawChart5() {
    	sarr.push(arr3);
    	sarr[0].push(den,json_var);
    	sarr[3].push(mar);
    	arr4.splice(0,0,apr);
    	sarr.push(arr4);
    	
      var data = google.visualization.arrayToDataTable(sarr);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "No. of Transactions by Account Type : Monthly",
        width: 600,
        height: 400,
        bar: {groupWidth: "75%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.BarChart(document.getElementById("barchart_values"));
      chart.draw(view, options);
  }
    MYFUNC5= function() {
  	  google.charts.setOnLoadCallback(drawChart5);
  	 
    };

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*line chart canvas element 
    <canvas id="buyers" width="600" height="400"></canvas>
    pie chart canvas element
    <canvas id="countries" width="600" height="400"></canvas>
    bar chart canvas element
    <canvas id="income" width="600" height="400"></canvas>
    <script>
        // line chart data
        var buyerData = {
            labels : ["January","February","March","April","May","June"],
            datasets : [
            {
                fillColor : "rgba(172,194,132,0.4)",
                strokeColor : "#ACC26D",
                pointColor : "#fff",
                pointStrokeColor : "#9DB86D",
                data : [203,156,99,251,305,247]
            }
        ]
        }
        // get line chart canvas
        var buyers = document.getElementById('buyers').getContext('2d');
        // draw line chart
        new Chart(buyers).Line(buyerData);
        // pie chart data
        var pieData = [
            {
                value: 20,
                color:"#878BB6"
            },
            {
                value : 40,
                color : "#4ACAB4"
            },
            {
                value : 10,
                color : "#FF8153"
            },
            {
                value : 30,
                color : "#FFEA88"
            }
        ];
        // pie chart options
        var pieOptions = {
             segmentShowStroke : false,
             animateScale : true
        }
        // get pie chart canvas
        var countries= document.getElementById("countries").getContext("2d");
        // draw pie chart
        new Chart(countries).Pie(pieData, pieOptions);
        // bar chart data
        var barData = {
            labels : ["January","February","March","April","May","June"],
            datasets : [
                {
                    fillColor : "#48A497",
                    strokeColor : "#48A4D1",
                    data : [456,479,324,569,702,600]
                },
                {
                    fillColor : "rgba(73,188,170,0.4)",
                    strokeColor : "rgba(72,174,209,0.4)",
                    data : [364,504,605,400,345,320]
                }
            ]
        }
        // get bar chart canvas
        var income = document.getElementById("income").getContext("2d");
        // draw bar chart
       new Chart(income).Bar(barData);
    </script>*/


  /*Type of Accounts Pie Chart*/ 

/*<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
  google.charts.load("current", {packages:["corechart"]});
  google.charts.setOnLoadCallback(drawChart);
  function drawChart() {
    var data = google.visualization.arrayToDataTable([
      ['Type of Account', 'No. of Accounts opened'],
      ['Current',     11],
      ['Savings',      7],
      ['Term Deposit',  2],
      ['Foreign Exchange', 4]
      
    ]);

    var options = {
      title: 'No. of Accounts opened',
      width: 800,
      height: 480,
      title: 'No. of Accounts opened by Type',
      colors: ['#878BB6', '#4ACAB4', '#FF8153', '#FFEA88', '#f6c7b6'],

      is3D: true,
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
    chart.draw(data, options);
  }
</script>
<div id="piechart_3d" style="width: 900px; height: 500px;"></div>


<!--  Credit/Debit Pie Chart -->

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
  google.charts.load("current", {packages:["corechart"]});
  google.charts.setOnLoadCallback(drawChart);
  function drawChart() {
    var data = google.visualization.arrayToDataTable([
      ['Credit Transactions', 'Debit Transactions'],
      ['Credit',     11],
      ['Debit',      7]
      
      
    ]);

    var options = {
      title: 'Credit vs Debit',
      width: 800,
      height: 480,
      title: 'Credit vs Debit',
      colors: ['#878BB6', '#4ACAB4'],

      is3D: true,
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
    chart.draw(data, options);
  }
</script>
<div id="piechart_3d" style="width: 900px; height: 500px;"></div>*/
    
