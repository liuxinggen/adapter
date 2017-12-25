# 针对RecyclerView的一个万能Adapter,集成了单击、长按等点击事件。

### Step 1. Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
### Step 2. Add the dependency
```
	dependencies {
	        compile 'com.github.liuxinggen:adapter:1.0'
	}
 ```

# 单一布局使用方法
```java
 SingleAdapter<SingleBean> adapter = new SingleAdapter<SingleBean>
                (SingleActivity.this, R.layout.adapter_single_type_layout,
                        singleBeanList) {
            @Override
            public void convert(ViewHolder holder, SingleBean singleBean, int position) {
                holder.setText(R.id.tv_single_title, singleBean.getTitleStr());
                holder.setOnClickListener(R.id.tv_single_title, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //TODO:单击事件
                    }
                });
                holder.setOnLongClickListener(R.id.tv_single_title, new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        //TODO:长按事件
                        return false;
                    }
                });
            }
        };
   ```
   # 多类型布局
   ### 1. 新建一个MultitemTypeAdapter，让它实现MultiItemTypeAdapter接口
   ```
   public class MultitemTypeAdapter extends MultiItemTypeAdapter<MultitemBean> {

    public MultitemTypeAdapter(Context context, List<MultitemBean> datas) {
        super(context, datas);
        addItemViewDelegate(new TypeAdapter1(context));
        addItemViewDelegate(new TypeAdapter2(context));
     }
   }
   ```
   ### 2. 新建你的Type
   ```
   public class TypeAdapter1 implements ItemViewDelegate<MultitemBean> {

    private Context context;

    public TypeAdapter1(Context context) {
        this.context = context;
    }
   /**
     * 区分的TYPE
     * @return
     */
    @Override
    public int getItemType() {
        return 0;
    }

    @Override
    public boolean isForViewType(MultitemBean item, int position) {
        if (position <= 3) {
            return true;
        }
        return false;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.adapter_main_fragment_layout;
    }

    @Override
    public void convert(ViewHolder holder, MultitemBean multitemBean, int position) {
        holder.setText(R.id.tv_title, multitemBean.getTitle());
        holder.setOnClickListener(R.id.tv_title, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO:单击事件
            }
         });
        holder.setOnLongClickListener(R.id.tv_title, new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //TODO:长按事件
                return false;
            }
          });
      }
   }

   ```
   ### 3. 添加Adapter到你的RecyclerView中
   ```
   MultitemTypeAdapter adapter = new MultitemTypeAdapter(MultitemTyleActivity.this,
                multitemBeans);
   rv.setAdapter(adapter);
   
   ```
