class CreateVideos < ActiveRecord::Migration
  def change
    create_table :videos do |t|
      t.string :file_name
      t.string :format
      t.integer :duration

      t.timestamps
    end
  end
end
