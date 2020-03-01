$(input).on('input', function() {
    function mn(t) {
        const e = t.currentTarget,
            n = dn.get(e);
        n && (n.inputed = !0, n.keypressed || fn(e))
    }
});

$(input).on('keydown', function() {
    function hn(t) {
        const e = t.currentTarget,
            n = dn.get(e);
        n && (n.keypressed = !0, null != n.timer && clearTimeout(n.timer))
    }
});

$(input).on('keyup', function() {
    function pn(t) {
        const e = t.currentTarget,
            n = dn.get(e);
        n && (n.keypressed = !1, n.inputed && fn(e))
    }
});
