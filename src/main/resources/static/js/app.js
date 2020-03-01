window.TSAPP = window.TSAPP || {name: 'TSAPP'};

(function(TSAPP) {
    TSAPP._baseURL = _getBaseURL();
    TSAPP._baseAPI = TSAPP._baseURL + '/api';
    TSAPP.options = {};

    function _getBaseURL() {
        var path;
        var thisFilePath = '/js/app.js';
        var scripts = document.getElementsByTagName('script');
        for(let i = 0; i < scripts.length; i++) {
            if (!scripts[i].src) { continue; }
            let sourceFullUrl = _getSourceFullUrl(scripts[i].src);
            let diff = sourceFullUrl.length - thisFilePath.length;
            if(diff >= 0 && sourceFullUrl.lastIndexOf(thisFilePath) === diff) {
                path = sourceFullUrl.substring(0, diff);
                break;
            }
        }
        return path;
    }

    function _getSourceFullUrl(path) {
        let el = document.createElement('span');
        el.innerHTML = "<a href='" + path + "'/>";
        return el.firstChild.href;
    }
})(window.TSAPP);


/**
 * HELPER utility
 */
TSAPP.util = (function(TSAPP) {
    function _isUndefined(value) {
        return (typeof value === 'undefined' || value === null);
    }

    function _isEmpty(value) {
        return _isUndefined(value) ||
                value === '' ||
                (typeof value === 'object' && Object.keys(value).length === 0) ||
                (Array.isArray(value) && value.length === 0);
    }

    function _isNumber(value) {
		return (typeof value === "number" || isFinite(value));
    }

    function _getUserIdFromUrl() {
        var pathname = window.location.pathname;
        var found = pathname.match(/\d+/);
        return found ? found[0] : null;
    }

    return {
        name: 'TSAPP Util',
        isUndefined: _isUndefined,
        isEmpty: _isEmpty,
        isNumber: _isNumber,
        getUserIdFromUrl: _getUserIdFromUrl,
    }
})(window.TSAPP);


/**
 * STORE utility
 */
TSAPP.store = (function(TSAPP) {
    var _cookies = (function() {
        return {
            get: function(key) {
                var name = key + "=";
                var decodedCookie = decodeURIComponent(document.cookie);
                var ca = decodedCookie.split(';');
                for(var i = 0; i < ca.length; i++) {
                    var c = ca[i];
                    while(c.charAt(0) == ' ') {
                        c = c.substring(1);
                    }
                    if(c.indexOf(name) == 0) {
                        return c.substring(name.length, c.length);
                    }
                }
                return "";
            },
            set: function(key, value, exdays) {
                var d = new Date();
                d.setTime(d.getTime() + (exdays*24*60*60*1000));
                var expires = "expires=" + d.toLocaleDateString('ja-JP');
                document.cookie = key + "=" + value + ";" + expires + ";path=/";
            }
        }
    })();

    var _localStorage = (function() {
        return _storageActions(window.localStorage);
    })();

    var _sessionStorage = (function() {
        return _storageActions(window.sessionStorage);
    })();

    function _storageActions(storage) {
        return {
            setItem: function(key, value) {
                if(value === undefined) value = null;
                storage[key] = JSON.stringify(value);
            },
            getItem: function(key) {
                return storage[key] ? JSON.parse(storage[key]) : null;
            },
            removeItem: function(key) {
                try {
                    delete storage[key];
                } catch(ex) {
                    storage.removeItem(key);
                }
            },
            clear: function() {
                storage.clear();
            }
        }
    };

    return {
        name: 'TSAPP Store',
        cookies: _cookies,
        localStorage: _localStorage,
        sessionStorage: _sessionStorage,
    }
})(window.TSAPP);


/**
 * API Request utility
 */
TSAPP.rest = (function(TSAPP) {
    // Send GET request
    function _get(url, requestData, options) {
    	_sendRequest(url, requestData, 'GET', options);
    }

    // Send POST request
    function _post(url, requestData, options) {
        _sendRequest(url, requestData, 'POST', options);
    }
    
    function _sendRequest(url, requestData, type, options) {
    	var requestOptions = options.options || {};
    	var isLoading = (requestOptions.hasOwnProperty('isLoading') && requestOptions.isLoading === false) ? false : true;
        if(!requestOptions.hasOwnProperty('async')) {
        	requestOptions.async = true;
        }

        var requestParams = {
        	url: url,
        	data: requestData,
        	cache: false,
        	type: type,
        	dataType: 'json',
        	contentType: 'application/json',
        	beforeSend: function(xhr) {},
        	success: function(data, status, xhr) {
        		if($.isFunction(options.successHandler)) {
                    options.successHandler(data, status, xhr);
                }
        	},
        	error: function(xhr, status, error) {
        	    if(xhr.status == 200) {
        	        TSAPP.view.redirect("/login");
        	    }
        		else if($.isFunction(options.errorHandler)) {
                    options.errorHandler(xhr, status, error);
                }
        	}
        }
        requestParams = $.extend(requestParams, requestOptions);

        if(isLoading) {
            TSAPP.view.showAjaxLoadingSpinner();
        }

    	$.ajax(requestParams);
    };

    function _download(url, dataType, contentType) {
        $.ajax({
            url: url,
            type: 'GET',
            async: false,
            dataType: dataType,
            contentType: contentType,
            error: function(xhr, status, error) {
                console.log('Failed to download '+url);
            }
        });
    }

    return {
        name: 'TSAPP Rest',
        get: _get,
        post: _post,
        download: _download,
    }
})(window.TSAPP);


/**
 * VIEW utility
 */
TSAPP.view = (function(TSAPP) {
	function _dataTableConfig(locale = null) {
	    console.log('_dataTableConfig() --> locale = '+locale);
	    if(locale == 'en') {
            return {
                sPaginationType: "full_numbers",
                bFilter: true,
                lengthChange: false,
                language: {
                    "sProcessing" : "Processing...",
                    "sLengthMenu" : "Show _MENU_ entries",
                    "sZeroRecords" : "No matching record found.",
                    "sInfo" : "Showing <b>_START_</b> to <b>_END_</b> of <b>_TOTAL_</b> entries",
                    "sInfoEmpty" : "Showing <b>0</b> to <b>0</b> of <b>0</b> entries",
                    "sInfoFiltered" : "（全 <b>_MAX_</b> 件より抽出）",
                    "sInfoPostFix" : "",
                    "sSearch" : "Search:",
                    "sUrl" : "",
                    "oPaginate" : {
                       "sFirst":    "<<",
                       "sPrevious": "<",
                       "sNext":     ">",
                       "sLast":     ">>"
                    }
                },
            }
	    }

        return {
            sPaginationType: "full_numbers",
            bFilter: true,
            lengthChange: false,
            language: {
                "sProcessing" : "処理中...",
                "sLengthMenu" : "_MENU_ 件表示",
                "sZeroRecords" : "データはありません。",
                "sInfo" : " <b>_TOTAL_</b> 件中 <b>_START_</b> から <b>_END_</b> まで表示",
                "sInfoEmpty" : " <b>0</b> 件中 <b>0</b> から <b>0</b> まで表示",
                "sInfoFiltered" : "（全 <b>_MAX_</b> 件より抽出）",
                "sInfoPostFix" : "",
                "sSearch" : "検索:",
                "sUrl" : "",
                "oPaginate" : {
                   "sFirst":    "<<",
                   "sPrevious": "<",
                   "sNext":     ">",
                   "sLast":     ">>"
                }
            },
        }
	}
	
	function _dataTableColumns(event) {
		
	}
	
	function _dataTableOrder(event) {
		
	}
	
	function _dataTableDrawCallback(config) {

	}

	function _redirect(uri) {
	    const url = TSAPP._baseURL + uri;
	    window.location.href = url;
	}

	function _showAjaxLoadingSpinner() {
	    $(document).on("ajaxStart", function() {
	        $('#loading').show().css({'display': 'flex'});
	    })
	    .on("ajaxStop", function() {
	        setTimeout(function() {
	            $('#loading').hide();
	        }, 200);
	    });
	}

    function _showLoadingSpinner() {
        $('#loading').show();
    }

	function _hideLoadingSpinner() {
        $('#loading').hide();
	}

	return {
	    name: 'TSAPP View',
		dataTableConfig: _dataTableConfig,
		redirect: _redirect,
		showAjaxLoadingSpinner: _showAjaxLoadingSpinner,
		showLoadingSpinner: _showLoadingSpinner,
		hideLoadingSpinner: _hideLoadingSpinner,
	}
})(window.TSAPP);


/**
 * LOCALIZATION utility
 */
TSAPP.locale = (function(TSAPP) {
    var _ja, _en = {};
    var _localeName = '_LOCALE';

	var _init = (function() {
	    var locale = 'ja';
        var fileURL = TSAPP._baseURL + '/lang/ja.json';
        $.ajax({
            url: fileURL,
            type: 'GET',
            async: false,
            dataType: 'json',
            contentType: 'application/json',
            success: function(data, status, xhr) {
                _ja = data;
            },
            error: function(xhr, status, error) {
                TSAPP.locales[locale] = {};
            }
        });
	})();

    var _currentLocale = (function() {
        var locale = TSAPP.store.cookies.get(_localeName);
        return locale ? locale : 'ja';
    })();

	function _trans(str, ...args) {
	    const json = TSAPP.locale[_currentLocale];
	    var rawStr = json[str] ? json[str] : str;
	    if(args.length > 0) {
	        args.forEach((arg, index) => {
	            let replace = `\\{${index+1}\\}`;
	            let regex = new RegExp(replace, "g");
	            rawStr = rawStr.replace(regex, arg);
	        });
	    }
	    return rawStr;
	}

	return {
	    name: 'TSAPP Localization',
	    localeName: _localeName,
	    supported: ['ja', 'en'],
        ja: _ja,
        en: _en,
	    init: _init,
		currentLocale: _currentLocale,
		_: _trans,
	}
})(window.TSAPP);
