queue()
    .defer(d3.json, "/realtors")
    .await(makeGraphs);

function makeGraphs(error, apiData) {
 
 

	    	//Start Transformations
	    		var dataSet = apiData;
	    		var dateFormat = d3.time.format("%Y-%m-%d");
	    		dataSet.forEach(function(d) {
	    			d.realtor_submission_date = dateFormat.parse(d.realtor_submission_date);
	    					d.realtor_submission_date.setDate(1);
	    			d.ri_id = +d.ri_id;
	    		});

                 var realtor_state = 'CA'

	    		//Create a Crossfilter instance
	    		var ndx = crossfilter(dataSet);

	    		//Define Dimensions
	    		var datePosted = ndx.dimension(function(d) { return d.realtor_submission_date; });
	    		var gradeLevel = ndx.dimension(function(d) { return d.realtor_transaction_symbol; });
	    		var resourceType = ndx.dimension(function(d) { return d.realtor_transaction_type; });
	    		var fundingStatus = ndx.dimension(function(d) { return d.realtor_verification_status; });
	    		var povertyLevel = ndx.dimension(function(d) { return d.realtor_branch_no; });
	    		var state = ndx.dimension(function(d) { return realtor_state; });
	    		var totalDonations  = ndx.dimension(function(d) { return d.realtor_transaction_total_amt; });


	    		//Calculate metrics
	    		var projectsByDate = datePosted.group(); 
	    		var projectsByGrade = gradeLevel.group(); 
	    		var projectsByResourceType = resourceType.group();
	    		var projectsByFundingStatus = fundingStatus.group();
	    		var projectsByPovertyLevel = povertyLevel.group();
	    		var stateGroup = state.group();

	    		var all = ndx.groupAll();

	    		//Calculate Groups
	    		var totalDonationsState = state.group().reduceSum(function(d) {
	    			return d.realtor_transaction_total_amt;
	    		});

	    		var totalDonationsGrade = gradeLevel.group().reduceSum(function(d) {
	    			return d.realtor_transaction_symbol;
	    		});

	    		var totalDonationsFundingStatus = fundingStatus.group().reduceSum(function(d) {
	    			return d.realtor_verification_status;
	    		});



	    		var netTotalDonations = ndx.groupAll().reduceSum(function(d) {return d.realtor_transaction_total_amt;});

	    		//Define threshold values for data
	    		var minDate = datePosted.bottom(1)[0].realtor_submission_date;
	    		var maxDate = datePosted.top(1)[0].realtor_submission_date;

	    	console.log(minDate);
	    	console.log(maxDate);

	    	    //Charts
	    		var dateChart = dc.lineChart("#date-chart");
	    		var gradeLevelChart = dc.rowChart("#grade-chart");
	    		var resourceTypeChart = dc.rowChart("#resource-chart");
	    		var fundingStatusChart = dc.pieChart("#funding-chart");
	    		var povertyLevelChart = dc.rowChart("#poverty-chart");
	    		var totalProjects = dc.numberDisplay("#total-projects");
	    		var netDonations = dc.numberDisplay("#net-donations");
	    		var stateDonations = dc.barChart("#state-donations");


	    	  selectField = dc.selectMenu('#menuselect')
	    	        .dimension(state)
	    	        .group(stateGroup); 

	    	       dc.dataCount("#row-selection")
	    	        .dimension(ndx)
	    	        .group(all);


	    		totalProjects
	    			.formatNumber(d3.format("d"))
	    			.valueAccessor(function(d){return d; })
	    			.group(all);

	    		netDonations
	    			.formatNumber(d3.format("d"))
	    			.valueAccessor(function(d){return d; })
	    			.group(netTotalDonations)
	    			.formatNumber(d3.format(".3s"));

	    		dateChart
	    			//.width(600)
	    			.height(220)
	    			.margins({top: 10, right: 50, bottom: 30, left: 50})
	    			.dimension(datePosted)
	    			.group(projectsByDate)
	    			.renderArea(true)
	    			.transitionDuration(500)
	    			.x(d3.time.scale().domain([minDate, maxDate]))
	    			.elasticY(true)
	    			.renderHorizontalGridLines(true)
	    	    	.renderVerticalGridLines(true)
	    			.xAxisLabel("Year")
	    			.yAxis().ticks(6);

	    		resourceTypeChart
	    	        //.width(300)
	    	        .height(220)
	    	        .dimension(resourceType)
	    	        .group(projectsByResourceType)
	    	        .elasticX(true)
	    	        .xAxis().ticks(5);

	    		povertyLevelChart
	    			//.width(300)
	    			.height(220)
	    	        .dimension(povertyLevel)
	    	        .group(projectsByPovertyLevel)
	    	        .xAxis().ticks(4);

	    		gradeLevelChart
	    			//.width(300)
	    			.height(220)
	    	        .dimension(gradeLevel)
	    	        .group(projectsByGrade)
	    	        .xAxis().ticks(4);

	    	  
	    	          fundingStatusChart
	    	            .height(220)
	    	            //.width(350)
	    	            .radius(90)
	    	            .innerRadius(40)
	    	            .transitionDuration(1000)
	    	            .dimension(fundingStatus)
	    	            .group(projectsByFundingStatus);


	    	    stateDonations
	    	    	//.width(800)
	    	        .height(220)
	    	        .transitionDuration(1000)
	    	        .dimension(state)
	    	        .group(totalDonationsState)
	    	        .margins({top: 10, right: 50, bottom: 30, left: 50})
	    	        .centerBar(false)
	    	        .gap(5)
	    	        .elasticY(true)
	    	        .x(d3.scale.ordinal().domain(state))
	    	        .xUnits(dc.units.ordinal)
	    	        .renderHorizontalGridLines(true)
	    	        .renderVerticalGridLines(true)
	    	        .ordering(function(d){return d.value;})
	    	        .yAxis().tickFormat(d3.format("s"));






	    	    dc.renderAll();
 
	};