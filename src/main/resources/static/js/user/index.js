const TSAPP = window.TSAPP || {};
import User from './user.js';

$(document).ready(function() {
    const userInstance = new User();
    console.log('Departments', departments);
    userInstance.data.departments = departments;
    
    userInstance.prototype = function() {
    	this.name = 'UserPrototypeName';
    }
    userInstance.prototype.initDataTable = function(event) {
    	console.log(event);
    };
    
    $('#searchBtn').on('click', userInstance, function(event) {
    	event.data.search.apply(this, arguments);
    });
    
    $('#departmentSelect').on('change', userInstance, function(event) {
    	event.data.onDepartmentChange.apply(this, arguments);
    });
    
    $('.nav-flyout-anchor').mouseenter(function() {
    	$('#nav-flyout-icp-footer-flyout').css({
    		"display": '',
    		"position": 'absolute'
    	});
    })
//    .mouseleave(function() {
//    	$('#nav-flyout-icp-footer-flyout').css("display", 'none');
//    });
//    
//    $('#nav-flyout-icp-footer-flyout').mouseenter(function() {
//    	$('#nav-flyout-icp-footer-flyout').css("display", '');
//    })
//    .mouseleave(function() {
//    	$('#nav-flyout-icp-footer-flyout').css("display", 'none');
//    });
    
//    $('#tableUsers').DataTable();
});
