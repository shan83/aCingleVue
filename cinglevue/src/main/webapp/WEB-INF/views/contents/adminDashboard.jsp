<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="style/jquery.dataTables_themeroller.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript" src="<c:url value="js/jquery.dataTables.min.js" />"></script>

<link href="<c:url value="style/input_form_custom_style.css"/>" rel="stylesheet" type="text/css">

<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		var subject = 'all';
		addDataToDb();
		$('#search_cat').html(' / '+subject);
		searchTerms();
		initTable(subject);
	} );

	function initTable(value){
		var oTable = $('#example').dataTable( {
			"bJQueryUI": true,
			 "bProcessing": true,
			 "bDestroy": true,
			 "iDisplayLength": 10,
		     "sAjaxSource": 'marksList.htm?subject=' + value,	
	    	 "aoColumns": [
	    	               { "mData": "school" },
	    	               { "mData": "latestY3" },
	    	               { "mData": "latestY5" },
	    	               { "mData": "latestY7" },
	    	               { "mData": "latestY9" },
	    	               { "mData": "rawGainY3Y5"},  
	    	               { "mData": "factoredGainY3Y5" },
	    	               { "mData": "glgY3Y5" },
	    	               { "mData": "latestGainInGainY3Y5" }
	    	               
	    	           ]	    	           
		});

	}

	function addDataToDb() { 	
		$.get('addJsonDataToDb.htm', {
		}, function(data) {
			if (data.status == 'success') {
				//window.location = 'adminDashboard.htm';
			}
		});
	}

	function searchTerms() {
		var appendText= '';
		$('#searchCategory').html('');
		$.get('subjects.htm',{
			},function(data){
				appendText = appendText + '<option value="all">all</option>';
					if (data.data.subjects.length != 0) {
						$.each(data.data.subjects,function(index, value) {
						appendText = appendText + '<option value="'+value+'">'+value+'</option>';
						});
						
					}
					$('#searchCategory').html(appendText);
				});

	}
	
	function filterByCategory() {
		var subject = $('#searchCategory').val();
		$('#search_cat').html(' / '+subject);
		initTable(subject);
	}
	
	//------------------------------------------------search end-----------------------------------------------------------------
</script>
<c:set var="functionToCall" value="getSearchedData()" />
<div style="width: 50%;float: left;padding-top: 23px;font-weight: bold;"><span>Pines School District</span><span id="search_cat"></span></div>
	<%@include file="includes/dashboard/mainSearch.jsp" %>
<div style="clear: both;"></div>
<div style="padding: 15px 0px;" class="bodyContent">
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
		<thead>
			<tr>
				<th width="25%">School</th>
				<th width="10%">LatestY3</th>				
				<th width="10%">LatestY5</th>
				<th width="10%">LatestY7</th>
				<th width="10%">LatestY9</th>
				<th width="5%">RawGainY3Y5</th>
				<th width="5%">FactoredGainY3Y5</th>							
				<th width="8%">GlgY3Y5</th>
				<th width="17%">LatestGainInGainY3Y5</th>
				
			</tr>
		</thead>
		<tbody>
			
		</tbody>
		<tfoot>
			<tr>
				<th>School</th>
				<th>LatestY3</th>				
				<th>LatestY5</th>
				<th>LatestY7</th>
				<th>LatestY9</th>
				<th>RawGainY3Y5</th>
				<th>FactoredGainY3Y5</th>							
				<th>GlgY3Y5</th>
				<th>LatestGainInGainY3Y5</th>
			</tr>
		</tfoot>
	</table>
</div>

