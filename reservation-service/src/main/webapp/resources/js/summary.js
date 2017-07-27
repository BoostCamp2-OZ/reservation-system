class Summary extends eg.Component {
	constructor(root, opt) {
		super();
        this.root = root;
		this.due = root.find('#due_count');
		this.used = root.find('#used_count');
		this.canceled = root.find('#canceled_count');
		this.total = root.find('#total_count');
		this.opt = opt;
		this.messenger = opt.messenger;
		this.bindEvents();
	}
	bindEvents() {
		this.messenger.on('reCount', this.reCount.bind(this));
        this.total.on('click', this.tab.bind(this));
        this.due.on('click', this.tab.bind(this));
        this.used.on('click', this.tab.bind(this));
        this.canceled.on('click', this.tab.bind(this));
	}
	reCount() {
		var num0 = this.opt.obj0.childrenLength, num1 = this.opt.obj1.childrenLength, num2 = this.opt.obj2.childrenLength, num3 = this.opt.obj3.childrenLength;
		this.due.html(num0 + num1);
		this.used.html(num2);
		this.canceled.html(num3);
		this.total.html(num0 + num1 + num2 + num3);
	}
    tab(e) {
        var target = $(e.target);
        this.root.find('a.link_summary_board').removeClass('on');
        target.closest('a.link_summary_board').addClass('on');
        this.messenger.trigger('tab', target);
    }
}