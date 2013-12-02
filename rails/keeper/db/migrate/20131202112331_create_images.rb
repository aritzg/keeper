class CreateImages < ActiveRecord::Migration
  def change
    create_table :images do |t|
      t.string :file_name
      t.string :format
      t.integer :width
      t.integer :height

      t.timestamps
    end
  end
end
